module.exports = {
  root: true,

  env: {
    node: true,
  },

  extends: [
    "plugin:vue/vue3-essential",
    // "eslint:recommended",
    // "plugin:prettier/recommended",
  ],

  parserOptions: {
    parser: '@babel/eslint-parser',
  },

  rules: {
    'no-console': 'off',
    'no-debugger': 'off',
    "vue/valid-template-root": "off",
    "vue/no-parsing-error": "off",
    "vue/multi-word-component-names": "off",
  },

  'extends': [
    'plugin:vue/vue3-essential',
    // 'eslint:recommended',
    // 'plugin:prettier/recommended'
  ]
};
