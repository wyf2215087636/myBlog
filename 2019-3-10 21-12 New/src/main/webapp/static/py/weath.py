import urllib.request


request = urllib.request.Request("https://api.mlwei.com/music/api/wy/?key=523077333&cache=0&type=url&id=32507038")
response = urllib.request.urlopen(request)
html = response.read()
print(html)

