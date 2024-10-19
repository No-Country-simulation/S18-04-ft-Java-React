import { z } from 'zod';
import { emailSchema, uuidSchema } from './baseSchema';

export const userSchema = emailSchema.merge(uuidSchema).extend({
  isFirstSignin: z.boolean().optional(),
});
