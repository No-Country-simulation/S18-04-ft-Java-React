import { z } from 'zod';

export const manageTeamsSchema = z.object({
  eventNum: z
    .string({ required_error: 'El Identificador del Evento es obligatorio' })
    .uuid({ message: 'Debe ser un UUID válido' }),
  scheduleNom: z
    .string({ required_error: 'El nombre del horario es obligatorio' })
    .min(4, { message: 'Debe poseer más de 4 caracteres' })
    .max(20, { message: 'No debe poseer más 20 cracteres' }),
  frameworkFront: z
    .string({ required_error: 'El nombre del framework del rol para Frontend es obligatorio' })
    .min(4, { message: 'Debe poseer más de 4 caracteres' })
    .max(20, { message: 'No debe poseer más 20 cracteres' }),
  frontQuantity: z
    .number({ message: 'La cantidad del rol por equipo es obligatoria' })
    .positive({ message: 'Debe ser un numero positivo' }),
  backQuantity: z
    .number({ message: 'La cantidad del rol por equipo es obligatoria' })
    .positive({ message: 'Debe ser un numero positivo' }),
  qaQuantity: z
    .number({ message: 'La cantidad del rol por equipo es obligatoria' })
    .positive({ message: 'Debe ser un numero positivo' }),
  pmQuantity: z
    .number({ message: 'La cantidad del rol por equipo es obligatoria' })
    .positive({ message: 'Debe ser un numero positivo' }),
  uxQuantity: z
    .number({ message: 'La cantidad del rol por equipo es obligatoria' })
    .positive({ message: 'Debe ser un numero positivo' }),
});
