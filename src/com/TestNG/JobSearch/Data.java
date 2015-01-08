package com.TestNG.JobSearch;

public class Data {
	static String dima_login;
	static String dima_password;
	static String dima_zipcode;
	
	static String olya_login;
	static String olya_password;
	static String olya_zipcode;
	
	//DICE
	static String dima_dice_keywords;
	static String dima_dice_expectedTitle;
	
	static String olya_dice_keywords;
	static String olya_dice_expectedTitle;
		
	//MONSTER
	static String dima_monster_keyword1;
	static String dima_monster_keyword2;
	static String dima_monster_keyword3;
	static String dima_monster_keyword4;
	static String dima_monster_keyword5;
	static String dima_monster_keyword6;
	static String dima_monster_expectedTitle;
	
	static String olya_monster_keyword1;
	static String olya_monster_keyword2;
	static String olya_monster_keyword3;
	static String olya_monster_keyword4;
	static String olya_monster_keyword5;
	static String olya_monster_keyword6;
	static String olya_monster_expectedTitle;
	
	//CAREERBUILDER
	static String dima_careerbuilder_keywords;
	static String dima_careerbuilder_expectedTitle;
	static String dima_careerbuilder_city1;
	static String dima_careerbuilder_city2;
	static String dima_careerbuilder_city3;
	static String dima_careerbuilder_salary;
	
	static String olya_careerbuilder_keywords;
	static String olya_careerbuilder_expectedTitle;
	static String olya_careerbuilder_city1;
	static String olya_careerbuilder_city2;
	static String olya_careerbuilder_city3;
	static String olya_careerbuilder_salary;
	
	//LINKEDIN
	static String dima_linkedin_keywords;
	static String dima_linkedin_expectedResult;
	
	static String olya_linkedin_keywords;
	static String olya_linkedin_expectedResult;
	

    static {
    	dima_login = "dimashyshkin@hotmail.com";
    	dima_password = "dima8439";
    	dima_zipcode = "75093";
    	
    	olya_login = "olhashyshkina@gmail.com";
    	olya_password = "28514500olya";
    	olya_zipcode = "75093";
    	
    	//DICE
    	dima_dice_keywords = "(qa OR sqa OR tester OR test OR quality OR selenium OR webdriver OR automation OR SDET OR API)";
    	dima_dice_expectedTitle = "Boolean search Jobs , Employment in " + dima_zipcode + " | Dice.com";
    	
    	olya_dice_keywords = "(qa sqa tester test quality)";
    	olya_dice_expectedTitle = "Boolean search Jobs , Employment in " + olya_zipcode + " | Dice.com";

    	//MONSTER
    	dima_monster_keyword1 = "QA";
    	dima_monster_keyword2 = "Automation";
    	dima_monster_keyword3 = "Automated";
    	dima_monster_keyword4 = "Selenium";
    	dima_monster_keyword5 = "Soap UI";
    	dima_monster_keyword6 = "WebDriver";
    	dima_monster_expectedTitle = "Jobs in " + dima_zipcode;
    	
    	olya_monster_keyword1 = "QA";
    	olya_monster_keyword2 = "SQA";
    	olya_monster_keyword3 = "tester";
    	olya_monster_keyword4 = "QA";
    	olya_monster_keyword5 = "test";
    	olya_monster_keyword6 = "quality";
    	olya_monster_expectedTitle = "Jobs in " + olya_zipcode;
    	
    	//CAREERBUILDER
    	dima_careerbuilder_keywords = "qa, sqa, tester, test, quality, selenium, webdriver, automation, SDET, API";
    	dima_careerbuilder_city1 = "Plano, TX";
    	dima_careerbuilder_city2 = "Richardson, TX";
    	dima_careerbuilder_city3 = "Carrollton, TX";
    	dima_careerbuilder_salary = "$70,000";
    	dima_careerbuilder_expectedTitle = "Keywords Jobs in " + dima_careerbuilder_city1 + ", " + dima_careerbuilder_city2 + " and " + dima_careerbuilder_city3 + " on CareerBuilder.com";
    			
    	olya_careerbuilder_keywords = "qa, sqa, tester, test, quality";
    	olya_careerbuilder_city1 = "Plano, TX";
    	olya_careerbuilder_city2 = "Richardson, TX";
    	olya_careerbuilder_city3 = "Carrollton, TX";
    	olya_careerbuilder_salary = "$30,000";
    	olya_careerbuilder_expectedTitle = "Keywords Jobs in " + olya_careerbuilder_city1 + ", " + olya_careerbuilder_city2 + " and " + olya_careerbuilder_city3 + " on CareerBuilder.com";
    	
    	//LINKEDIN
    	dima_linkedin_keywords = "qa automation";
    	dima_linkedin_expectedResult = "results for " + dima_linkedin_keywords;
    	
    	olya_linkedin_keywords = "software qa";
    	olya_linkedin_expectedResult = "results for " + olya_linkedin_keywords;
    }
}
