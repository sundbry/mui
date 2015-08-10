all: resources/public/material_ui.js
	
node_modules:
	lein npm install

resources/public/material_ui.js: node_modules
	lein browserify-shim
