import { z } from 'zod';
import { emailSchema, passwordSchema } from './baseSchema';

export const signinSchema = emailSchema.merge(passwordSchema);

export const signupSchema = signinSchema
  .extend({
    repeatPassword: z.string({
      required_error: 'Debes confirmar la contraseña',
      message: 'Debes confirmar la contraseña',
    }),
  })
  .refine(data => data.password === data.repeatPassword, {
    message: 'Las contraseñas no coinciden',
    path: ['repeatPassword'],
  });

export const confirmSchema = z.object({
  name: z
    .string({ required_error: 'El nombre es requerido' })
    .min(3, 'El nombre debe tener al menos 8 caracteres')
    .max(60, 'El nombre debe tener hasta 60 caracteres como máximo'),
  lastName: z
    .string({ required_error: 'El apellido es requerido' })
    .min(3, 'El apellido debe tener al menos 8 caracteres')
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
