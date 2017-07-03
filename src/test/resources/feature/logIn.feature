Feature: login Test 

@Reg 
Scenario Outline: 
	Given user direct to the site "<siteurl>" 
	And user enter username "<user>" 
	And user enter password "<pass>" 
	When user click on the login button 
	Then validate home page "<url>" 
	Examples: 
		|siteurl   |user   | pass|url|
		|http://store.demoqa.com/products-page/your-account/|osura|Test@135|http://store.demoqa.com/products-page/your-account/?login=1|
		
