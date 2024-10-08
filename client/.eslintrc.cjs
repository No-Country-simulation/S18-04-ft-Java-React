const fs = require('fs');

module.exports = {
  extends: [
    'prettier',
    'plugin:react/recommended',
    'plugin:tailwindcss/recommended',
    'plugin:import/recommended',
    'next',
  ],
  env: {
    jest: true,
    browser: true,
    es2021: true,
    node: true,
  },
  rules: {
    'sort-imports': [
      'error',
      {
        ignoreCase: true,
        ignoreDeclarationSort: true,
      },
    ],
    'import/order': [
      1,
      {
        groups: ['external', 'builtin', 'internal', 'sibling', 'parent', 'index'],
        pathGroups: [
          ...getDirectoriesToSort().map(singleDir => ({
            pattern: `${singleDir}/**`,
            group: 'internal',
          })),
          {
            pattern: 'env',
            group: 'internal',
          },
          {
            pattern: 'theme',
            group: 'internal',
          },
          {
            pattern: 'public/**',
            group: 'internal',
            position: 'after',
          },
        ],
        pathGroupsExcludedImportTypes: ['internal'],
        alphabetize: {
          order: 'asc',
          caseInsensitive: true,
        },
      },
    ],
    'import/resolver': 'off',
    'import/no-unresolved': 'off',
    'react/react-in-jsx-scope': 'off',
    'no-empty-pattern': ['error', { allowObjectPatternsAsParameters: false }],
    'no-undef': ['warn', { typeof: false }],
    'react-hooks/rules-of-hooks': 'off',
    'tailwindcss/no-custom-classname': 'off',
    'tailwindcss/classnames-order': 'off',
    'testing-library/prefer-screen-queries': 'off',
    '@next/next/no-html-link-for-pages': 'off',
    'react-hooks/exhaustive-deps': 'off',
  },
};

function getDirectoriesToSort() {
  const ignoredSortingDirectories = [
    '.git',
    '.next',
    '.vscode',
    'node_modules',
    '.github',
    '.husky',
    '.vercel',
    '.swc',
  ];
  return getDirectories(process.cwd()).filter(f => !ignoredSortingDirectories.includes(f));
}

function getDirectories(path) {
  return fs.readdirSync(path).filter(function (file) {
    return fs.statSync(path + '/' + file).isDirectory();
  });
}
