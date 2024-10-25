import { z } from 'zod';

export const inscriptionSchema = z.object({
  type: z.string(),
  rol: z.string(),
  timeAvailability: z.string(),
  stack: z.string(),
  isTeamLeader: z.boolean(),
});
