import requests


class CBug:
    def __init__(self, url, h):
        self.url = url
        self.h = h
        try:
            self.over = requests.get(self.url, self.h)
            self.over.raise_for_status() 
        except requests.exceptions.RequestException as e:
            print(f"ERROR: {e}")


    def ReturnSth(self, command):
            if command == 'code':
                return self.over.status_code
            if command == "html":
                return self.over.text


header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 '
                  'Safari/537.36 Edg/126.0.0.0'}
url = 'http://cipstudio.top/'
f = CBug(url, header)
with open('test.html', 'w', encoding='utf-8') as file:
    file.write(f.ReturnSth("html"))

