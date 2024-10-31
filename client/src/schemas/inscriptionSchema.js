import { z } from 'zod';

export const inscriptionSchema = z.object({
  language: z.string(),
  frameworks: z.string(),
  rol: z.string(),
  timeAvailability: z.string(),
  isTeamLeader: z
    .string()
    .refine(value => value === 'true' || value === 'false', {
      message: "Debe ser 'true' o 'false'",
    })
    .transform(value => value === 'true'),
});
