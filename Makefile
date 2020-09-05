

build: src/page.clj
	clj -m page

dev:
	live-server & find src -type f | entr -r clj -m page





