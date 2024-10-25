/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './src/pages/**/*.{js,ts,jsx,tsx,mdx}',
    './src/components/**/*.{js,ts,jsx,tsx,mdx}',
    './src/app/**/*.{js,ts,jsx,tsx,mdx}',
    {
      raw: String.raw`(?<=\\btw\`(.*?)\`|cva\(\`(.*?)\`|clsx\((.*?)\))`,
    },
  ],
  theme: {
    extend: {
      colors: {
        background: 'var(--background)',
        foreground: 'var(--foreground)',
        primary: {
          50: '#1d90fc',
          100: '#0A2140',
          200: '#080940',
          300: '#06071b',
          400: '#050f22',
          500: '#051e33',
        },
        accent: {
          50: '#c5f263',
          100: '#0FF29F',
          200: '#14D9B5',
          300: '#00ffe0',
          400: '#0cfca7',
          500: '#08b54f',
        },
        secondary: {
          100: '#5F1BF2',
          200: '#5e17eb',
          300: '#281ca5',
          400: '#4a3aff',
          500: '#9747ff',
        },
      },
      fontFamily: {
        dmSans: 'var(--font-dm-sans)',
      },
      backgroundImage: {
        'gradient-bg': 'var(--bg-gradient)',
        'gradient-bg-radial': 'var(--bg-radial-gradient)',
        'gradient-green': 'var(--gradient-green-to-blue)',
        'gradient-green-100': 'var(--gradient-green-to-blue-100)',
        'gradient-green-200': 'var(--gradient-green-to-blue-200)',
        'gradient-custom':
          'linear-gradient(90deg, #1D8FF2 5.5%, #32D4E3 38.5%, #0FF29F 65.5%, #14D9B5 98%)',
      },
    },
  },
  plugins: [
    function ({ addUtilities }) {
      const newUtilities = {
        '.text-gradient-custom': {
          'background-image':
            'linear-gradient(90deg, #1D8FF2 5.5%, #32D4E3 38.5%, #0FF29F 65.5%, #14D9B5 98%)',
          'background-clip': 'text',
          '-webkit-background-clip': 'text',
          color: 'transparent',
        },
      };
      addUtilities(newUtilities, ['hover']);
    },
  ],

  future: {
    hoverOnlyWhenSupported: true,
    removeDeprecatedGapUtilities: true,
    standardFontWeights: true,
  },
};
