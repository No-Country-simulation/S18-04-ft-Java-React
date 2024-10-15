import { z } from 'zod';

// Ejemplo de como usar schemas con Zod
// Esta libreria se utiliza para validar que los valores de los objetos sean correctos
export const emailSchema = z.object({
  email: z
    .string({ message: 'El correo electronico es obligatorio' })
    .email('El email es invalido'),
});

// En lugar de repetir el esquema de email, podemos crear uno nuevo apartir del anterior "extendiendo el esquema"
export const signinSchema = emailSchema.extend({
  password: z
    .string({ required_error: 'La contraseña es requerida' })
    .min(6, 'La contraseña debe tener al menos 6 carecteres')
    .max(100, 'La contraseña debe tener hasta 100 caracteres como maximo'),
});

//TODO: Eliminar el name del esquema si no se va a utilizar
//TODO: Agregar validate password
//TODO: La validacion del password de arriba debe de coincidar con la del back
//TODO: Puedes validar si el password y el validate password son iguales con zod(busca en google como xd)
//TODO: Si ves necesario cambia los mensajes de error que devuelve
export const signupSchema = signinSchema.extend({
  name: z
    .string({ message: 'El nombre es requerido' })
    .min(1, 'El nombre debe tener mas de un caracter')
    .optional(),
});

/* 
export const signinSchema = loginShcema.extend({
  password: z.string({ message: 'La contraseña es requerida' }),
  email: z.string({ message: 'El correo electronico es obligatorio' }),
});

*/
