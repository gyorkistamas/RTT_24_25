import unittest
from selenium import webdriver
import page

class Testing(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get('https://saucedemo.com')

    def teardown(self):
        self.driver.close()

    def test_title(self):
        mainPage = page.MainPage(self.driver)
        assert mainPage.is_title_matching()

if __name__ == '__main__':
    unittest.main()