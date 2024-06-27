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


print("HeZhijun in CMS was here!!")

