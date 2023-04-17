#!/usr/bin/env sh

# 发生错误时终止
set -e

# 构建
npm run build

# 进入构建文件夹
# cd dist

# 放置 .nojekyll 以绕过 Jekyll 的处理。
# echo > .nojekyll

# 如果你要部署到自定义域名
# echo 'www.example.com' > CNAME

# git init
# git checkout -B page
git add dist -f
git commit -m"adding dist"

# 如果你要部署在 https://<USERNAME>.github.io
# git push -f git@github.com:<USERNAME>/<USERNAME>.github.io.git main

# 如果你要部署在 https://<USERNAME>.github.io/<REPO>
git subtree push --prefix dist origin gh-pages

cd -