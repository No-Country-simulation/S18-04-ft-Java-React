//TODO: El atributo name de este objeto debe de coincidir con el del objeto en el esquema de zod
export const registerStepOne = [
  {
    id: 'emailField',
    name: 'email',
    type: 'email',
    label: 'Correo electronico',
    icon: '/images/User.svg',
    tabindex: 1,
    autoComplete: 'new-email',
  },
  {
    id: 'passwordField',
    name: 'password',
    type: 'password',
    label: 'Contraseña',
    icon: '/images/Unlock.svg',
    tabindex: 2,
    autoComplete: 'new-password',
  },
  {
    id: 'repeatPasswordField',
    name: 'repeatPassword',
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
    name: 'name',
    type: 'text',
    label: 'Nombre',
    tabindex: 1,
    autoComplete: 'given-name',
  },
  {
    id: 'lastNameField',
    name: 'lastName',
    type: 'text',
    label: 'Apellido',
    tabindex: 2,
    autoComplete: 'family-name',
  },
  {
    id: 'linkedinField',
    name: 'linkedin',
    type: 'url',
    label: 'Linkedin',
    icon: '/images/Linkedin.svg',
    tabindex: 3,
  },
  {
    id: 'githubField',
    name: 'github',
    type: 'url',
    label: 'Github',
    icon: '/images/Github.svg',
    tabindex: 4,
  },
];
