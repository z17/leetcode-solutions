import random
import string


class Codec:
    URL = 'http://tinyurl.com/'
    LENGTH = 8

    urls_to_short = {}
    short_to_url = {}

    def encode(self, longUrl: str) -> str:
        if longUrl in self.urls_to_short:
            return self.get_tiny_url(self.urls_to_short[longUrl])

        random_short_part = ''.join(random.choices(string.ascii_letters + string.digits, k=self.LENGTH))
        short_url = self.get_tiny_url(random_short_part)
        self.urls_to_short[longUrl] = short_url
        self.short_to_url[short_url] = longUrl

        return short_url

    def decode(self, shortUrl: str) -> str:
        if shortUrl in self.short_to_url:
            return self.short_to_url[shortUrl]

        raise Exception('Unknown url')

    def get_tiny_url(self, shortPart: str) -> str:
        return self.URL + shortPart


codec = Codec()
url = 'http://yandex.ru/page/1'
encoded = codec.encode(url)
print(encoded)
print(codec.decode(encoded))
