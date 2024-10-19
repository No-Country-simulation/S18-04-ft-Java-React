import { z } from 'zod';

export const uuidSchema = z.object({
  id: z.string().uuid(),
});
export const emailSchema = z.object({
  email: z
    .string({ message: 'El correo electronico es obligatorio' })
    .email('El correo electronico es invalido'),
});

export const passwordSchema = z.object({
  password: z
    .string({ required_error: 'La contraseña es requerida' })
    .min(8, 'La contraseña debe tener al menos 8 caracteres')
    .max(100, 'La contraseña debe tener hasta 100 caracteres como máximo'),
});
