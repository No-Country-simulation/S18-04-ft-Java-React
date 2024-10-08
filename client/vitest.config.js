import react from '@vitejs/plugin-react';
import { defineConfig } from 'vitest/config';

import path from 'path';
import jsconfig from './jsconfig.json';

const raw = jsconfig.compilerOptions.paths;
const alias = {};
// Por defecto "vite" no reconoce los alias de las rutas
// por esto es necesario indicarle cual es la forma de resolver estos alias al compilarlo
for (const x in raw) {
  alias[x.replace('/*', '')] = raw[x].map(p => path.resolve(__dirname, p.replace('/*', '')));
}

export default defineConfig({
  plugins: [react()],
  resolve: {
    alias,
  },
  test: {
    globals: true,
    include: ['__test__/**/*.test.{js,jsx,ts,tsx}'],
    coverage: {
      include: ['src/**/*'],
      exclude: ['src/**/*.stories.{js,jsx,ts,tsx}', '**/*.d.ts'],
    },
    environment: 'jsdom',
  },
});
