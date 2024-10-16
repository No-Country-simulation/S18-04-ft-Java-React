import { z } from 'zod';

export const emailSchema = z.object({
  email: z
    .string({ message: 'El correo electronico es obligatorio' })
    .email('El email es invalido'),
});

export const signinSchema = emailSchema.extend({
  password: z
    .string({ required_error: 'La contraseña es requerida' })
    .min(8, 'La contraseña debe tener al menos 8 caracteres')
    .max(100, 'La contraseña debe tener hasta 100 caracteres como maximo'),
});

export const signupSchema = signinSchema
  .extend({
    repeatPassword: z.string({ required_error: 'Debes confirmar la contraseña' }),
  })
  .refine(data => data.password === data.repeatPassword, {
    message: 'Las contraseñas no coinciden',
    path: ['repeatPasswordd'],
  });
