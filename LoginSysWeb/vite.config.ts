import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    host: false
  },

  // base:'/LoginSysWeb/',
  base: process.env.NODE_ENV === 'production' ? '/LoginSysWeb/' : './',


  resolve:{
    alias: [
      { find: '@', replacement: path.resolve(__dirname, '/src') }
    ],
    }
})
