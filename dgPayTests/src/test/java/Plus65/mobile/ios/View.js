SRC>containers>Auth>View.js


import React, { Component, PropTypes } from 'react';
import {
  View,
  AsyncStorage,
  TouchableWithoutFeedback,
  Keyboard,
  Image,
  Alert,
} from 'react-native';
import { connect } from 'react-redux';
import DeviceInfo from 'react-native-device-info';
import { routes } from '../../router';
import s from './View.css.js';
import { formInitialState } from '../../utils/utilForm';
import { Button, InputText, MyText } from '../../common/component';
import {
  login,
  openModalPopupWarning,
  closeModalPopup,
  getMyNotifications,
  openModalPageLoader,
  closeModalPageLoader,
  getFullAccount,
  setUserPushNotification,
  setApiEndpoint,
} from '../../actions';
import iconArrowMiiLogo from '../../common/img/icon/arrowmii-logo.png';

class Auth extends Component {

  constructor(props) {
    super(props);

    const fields = ['email', 'password'];

    this.state = {
      ...formInitialState(fields),
      apiEnvClick: 0,
    };
  }

  componentDidMount() {
    AsyncStorage.getItem('user_email')
      .then(email => this.setState({ values: { email } }));
  }

  handleChangeText(type, value) {
    const { values, errors } = this.state;

    values[type] = value;
    errors[type] = null;

    this.setState({
      values,
      errors
    });
  }

  // validate formData and give err messages
  validate() {
    const { values } = this.state;
    const err = {};
    const emailFormat = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (!values.email) {
      err.email = 'Email can\'t be empty';
    } else if (!emailFormat.test(values.email)) {
      err.email = 'Invalid Email Format';
    }

    if (!values.password) {
      err.password = 'Password can\'t be empty';
    }

    if (Object.keys(err).length) {
      this.setState({ errors: err });
    }

    return Object.keys(err).length;
  }

  handleLogin() {
    const { values } = this.state;

    if (!this.validate()) {
      this.setState({ values: { ...values, password: null } });
      this.loginProcess(values);
    }
  }

  loginProcess(values) {
    this.props.login(values, () => {
      this.props.openModalPageLoader();
      this.props.getFullAccount(null, () => {
        AsyncStorage.getItem('user_device')
          .then(uuid => this.props.setUserPushNotification({ uuid }));
        if (this.props.userAccountConfirmed) {
          this.props.getMyNotifications();
          switch (this.props.userOnboarding) {
            case 0:
              this.props.navigator.replace(routes.onBoarding);
              break;
            case 1:
              this.props.navigator.replace(routes.skillsSet);
              break;
            case 2:
              this.props.navigator.replace(routes.gettingStarted);
              break;
            case 3:
              this.props.navigator.replace(routes.myJob);
              break;
            default:
              break;
          }
        } else {
          setTimeout(() => this.renderAccountNotConfirmedPopup(), 1000);
        }
        this.props.closeModalPageLoader();
      });
    }, this.renderLoginErrPopup.bind(this));
  }

  // click 7 times to change api environment
  clickApiChange() {
    const { apiEnvClick } = this.state;
    if (apiEnvClick >= 6) {
      this.setApiEnv();
    }
    return this.setState({ apiEnvClick: apiEnvClick < 6 ? (apiEnvClick + 1) : 0 });
  }

  setApiEnv() {
    const setApi = (env) => {
      this.props.setApiEndpoint(env);
      AsyncStorage.setItem('api_env', env);
    };

    return Alert.alert(
      'Developer Options', null,
      [
        { text: 'Production', onPress: () => setApi('prod') },
        { text: 'UAT', onPress: () => setApi('uat') },
        { text: 'Staging', onPress: () => setApi('staging') },
      ]
    );
  }

  renderLoginErrPopup() {
    return this.props.openModalPopupWarning({
      title: 'Invalid Login Account',
      customContent: (
        <View style={s.popupContainer}>
          <MyText style={s.popupText}>You entered a wrong email or password.</MyText>
          <MyText style={s.popupText}>Please try again.</MyText>
          <Button
            type="default"
            style={[s.popupBtn, s.popupBtnTop]}
            onPress={() => this.props.closeModalPopup()}
          >
            RETURN TO LOGIN
          </Button>
          <Button
            type="white"
            style={s.popupBtn}
            onPress={() => {
              this.props.closeModalPopup();
              this.props.navigator.push(routes.forgetPassword);
            }}
          >
            FORGOT PASSWORD
          </Button>
        </View>
      )
    });
  }

  renderAccountNotConfirmedPopup() {
    return this.props.openModalPopupWarning({
      title: 'Account not confirmed!',
      customContent: (
        <View style={s.popupContainer}>
          <MyText style={s.popupText}>
            Please confirm your account through the link sent to your email address.
          </MyText>
        </View>
      ),
    });
  }

  render() {
    const { navigator, apiEnv } = this.props;
    const { errors, values } = this.state;

    return (
      <TouchableWithoutFeedback accessible={false} onPress={() => Keyboard.dismiss()}>
        <View style={s.container}>

          <View style={s.logoContainer}>
            <Image
              source={iconArrowMiiLogo}
              style={s.logo}
              resizeMode='contain'
            />
          </View>

          <View style={s.authSection}>
            <View style={s.authField}>
              <InputText
                label="Email address"
                onChangeText={value => this.handleChangeText('email', value)}
                value={values.email}
                error={errors.email}
                keyboardType="email-address"
                onSubmitEditing={() => this._passwordInput.shouldFocus()}
                theme="white"
              />
            </View>
            <View style={s.authField}>
              <InputText
                ref={c => this._passwordInput = c}
                label="Password"
                onChangeText={value => this.handleChangeText('password', value)}
                value={values.password}
                error={errors.password}
                theme="white"
                secureTextEntry
              />
            </View>
          </View>

          <View style={s.buttonSection}>
            <View style={s.bottomContainer}>
              <Button type="default" onPress={() => this.handleLogin()}>
                LOGIN
              </Button>

              <MyText
                style={s.linkForgetPassword}
                onPress={() => navigator.push(routes.forgetPassword)}
              >
                Forgot Password?
              </MyText>
            </View>

            <View style={s.bottomContainer}>
              <MyText style={s.signupText}>Not yet a member?</MyText>
              <Button
                type="primary"
                onPress={() => navigator.push(routes.signup)}
                flat
              >
                CREATE AN ACCOUNT
              </Button>
            </View>
          </View>

          <MyText
            style={s.appVersion}
            onPress={this.clickApiChange.bind(this)}
          >
            {`V${DeviceInfo.getReadableVersion()}${apiEnv === 'prod' ? '' : apiEnv}`}
          </MyText>

        </View>
      </TouchableWithoutFeedback>
    );
  }
}

Auth.propTypes = {
  userOnboarding: PropTypes.number,
  userAccountConfirmed: PropTypes.bool,
  login: PropTypes.func.isRequired,
  openModalPopupWarning: PropTypes.func.isRequired,
  closeModalPopup: PropTypes.func.isRequired,
  getMyNotifications: PropTypes.func.isRequired,
  getFullAccount: PropTypes.func.isRequired,
  openModalPageLoader: PropTypes.func.isRequired,
  closeModalPageLoader: PropTypes.func.isRequired,
  setUserPushNotification: PropTypes.func.isRequired,
  setApiEndpoint: PropTypes.func.isRequired,
};

const mapStateToProps = (state) => ({
  userAccountConfirmed: state.settings.user && state.settings.user.isAccountConfirmed,
  userOnboarding: state.settings.user && state.settings.user.profile
    && state.settings.user.profile.partimer
    && state.settings.user.profile.partimer.onboarding_step,
  apiEnv: state.auth.device.env,
});

const mapDispatchToProps = (dispatch) => ({
  login: (params, onNext, onFail) => dispatch(login(params, onNext, onFail)),
  openModalPopupWarning: (params) => dispatch(openModalPopupWarning(params)),
  closeModalPopup: () => dispatch(closeModalPopup()),
  getMyNotifications: () => dispatch(getMyNotifications()),
  getFullAccount: (shouldLogin, onNext) => dispatch(getFullAccount(shouldLogin, onNext)),
  openModalPageLoader: () => dispatch(openModalPageLoader()),
  closeModalPageLoader: () => dispatch(closeModalPageLoader()),
  setUserPushNotification: (params) => dispatch(setUserPushNotification(params)),
  setApiEndpoint: (params) => dispatch(setApiEndpoint(params)),
});

export default connect(mapStateToProps, mapDispatchToProps)(Auth);
