from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()

driver.get('https://saucedemo.com')

user = driver.find_element(By.ID, 'login_credentials').text.split('\n')[1]

password = driver.find_element(By.CLASS_NAME, 'login_password').text.split('\n')[1]

driver.find_element(By.ID, 'user-name').send_keys(user)
driver.find_element(By.ID, 'password').send_keys(password)

driver.find_element(By.ID, 'login-button').click()

title = driver.find_element(By.CLASS_NAME, 'title').text

print(title)

input()