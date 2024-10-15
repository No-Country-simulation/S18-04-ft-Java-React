export const registerStepOne = [
  {
    id: 'emailField',
    name: 'emailField',
    type: 'email',
    label: 'Correo electronico',
    icon: '/images/User.svg',
    tabindex: 1,
    autoComplete: 'new-email',
  },
  {
    id: 'passwordField',
    name: 'passwordField',
    type: 'password',
    label: 'Contraseña',
    icon: '/images/Unlock.svg',
    tabindex: 2,
    autoComplete: 'new-password',
  },
  {
    id: 'repeatPasswordField',
    name: 'repeatPasswordField',
    type: 'password',
    label: 'Repetir contraseña',
    icon: '/images/Unlock.svg',
    tabindex: 3,
  },
];

export const loginFields = [
  {
    id: 'emailField',
    name: 'email',
    type: 'email',
    label: 'Correo electronico',
    icon: '/images/User.svg',
    tabindex: 1,
    autoComplete: 'email',
  },
  {
    id: 'passwordField',
    name: 'password',
    type: 'password',
    label: 'Contraseña',
    icon: '/images/Unlock.svg',
    tabindex: 2,
    activeForgot: true,
  },
];

export const registerStepTwo = [
  {
    id: 'nameField',
    name: 'nameField',
    type: 'text',
    label: '* Nombre',
    tabindex: 1,
    autoComplete: 'given-name',
  },
  {
    id: 'lastNameField',
    name: 'lastNameField',
    type: 'text',
    label: '* Apellido',
    tabindex: 2,
    autoComplete: 'family-name',
  },
  {
    id: 'linkedinField',
    name: 'linkedinField',
    type: 'text',
    label: 'Linkedin',
    icon: '/images/Linkedin.svg',
    tabindex: 3,
  },
  {
    id: 'githubField',
    name: 'githubField',
    type: 'text',
    label: 'Github',
    icon: '/images/Github.svg',
    tabindex: 4,
  },
];