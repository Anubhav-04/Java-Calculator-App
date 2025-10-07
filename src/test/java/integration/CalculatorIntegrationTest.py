from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

# Chrome in headless mode for stability/CI

driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

try:
    driver.get("http://localhost:9100/index.html")
    wait.until(EC.title_contains("Simple Calculator"))
    assert "Simple Calculator" in driver.title

    # Interact with the form
    wait.until(EC.element_to_be_clickable((By.ID, "inputA"))).send_keys(5)
    wait.until(EC.element_to_be_clickable((By.ID, "inputB"))).send_keys(10)
    wait.until(EC.element_to_be_clickable((By.NAME, "add"))).click()
    final_add = wait.until(EC.visibility_of_element_located((By.NAME, "result")))
    assert "Sum: 15" in final_add.text
    time.sleep(3)
    wait.until(EC.element_to_be_clickable((By.NAME, "sub"))).click()
    final_add = wait.until(EC.visibility_of_element_located((By.NAME, "result")))
    assert "Difference: -5" in final_add.text
    time.sleep(3)
    wait.until(EC.element_to_be_clickable((By.NAME, "mul"))).click()
    final_add = wait.until(EC.visibility_of_element_located((By.NAME, "result")))
    assert "Product: 50" in final_add.text
    time.sleep(3)
    wait.until(EC.element_to_be_clickable((By.NAME, "div"))).click()
    final_add = wait.until(EC.visibility_of_element_located((By.NAME, "result")))
    assert "Quotient: 0" in final_add.text
    time.sleep(3)
finally:
    driver.quit()
