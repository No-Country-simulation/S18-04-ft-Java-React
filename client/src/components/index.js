// El archivo "index.js" se suele utilizar para facilitar las importaciones en JS
// A estos archivos se los conoce como "barrels"
// Y lo que hacen es importar la funcion/componente que quieras agrupar en el barrel
// Y luego re exportarlo en este archivo. De esta forma al importar alguno de estos archivos
// Las rutas seran mas cortas y simples (**Ejemplo de uso en signup/page.jsx**)
import { SignupForm } from './SignupForm/SignupForm';

export { SignupForm };
