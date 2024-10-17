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
    .max(100, 'La contraseña debe tener hasta 100 caracteres como máximo'),
});

export const signupSchema = signinSchema
  .extend({
    repeatPassword: z.string({ required_error: 'Debes confirmar la contraseña' }),
  })
  .refine(data => data.password === data.repeatPassword, {
    message: 'Las contraseñas no coinciden',
    path: ['repeatPasswordd'],
  });

export const confirmSchema = z.object({
  name: z
    .string({ required_error: 'El nombre es requerido' })
    .min(8, 'El nombre debe tener al menos 8 caracteres')
    .max(60, 'El nombre debe tener hasta 60 caracteres como máximo'),
  lastName: z
    .string({ required_error: 'El apellido es requerido' })
    .min(8, 'El apellido debe tener al menos 8 caracteres')
    .max(60, 'El apellido debe tener hasta 60 caracteres como máximo'),
  linkedin: z
    .string({ invalid_type_error: 'Debe ser una URL válida' })
    .url('Debe ser una URL válida')
    .optional(),
  github: z
    .string({ invalid_type_error: 'Debe ser una URL válida' })
    .url('Debe ser una URL válida')
    .optional(),
});
