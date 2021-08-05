
-- Address

 insert into address values(0,12,'Strada Soarelui');

-- Users

 insert into customer values (0,'admin','ROLE_ADMIN','admin',0);
 insert into customer values (1,'user','ROLE_USER','user',0);

-- Menu:

-- Espressso

 insert into ingredient values(0,'espresso',0.5);
 insert into recipe values(0,'espresso');
 insert into recipe_ingredients values(0,0);
 insert into coffee values(0,'espresso fast','images/espresso.png','espresso',0.5,0,0);

-- Machiatto

insert into ingredient values(1,'milk foam',0.2);
insert into recipe values(1,'machiatto');
insert into recipe_ingredients values(1,0);
insert into recipe_ingredients values(1,1);
insert into coffee values(1,'machiatto is good','images/machiatto.png','machiatto',0.7,0,1);

-- Coffee Latte

insert into ingredient values(2,'steamed milk',0.3);
insert into recipe values(2,'coffee latte');
insert into recipe_ingredients values(2,0);
insert into recipe_ingredients values(2,2);
insert into recipe_ingredients values(2,1);
insert into coffee values(2,'coffee latte i see','images/coffeelatte.png','coffee latte',1,0,2);

--   Cappuccino
insert into recipe values(3,'cappucino');
insert into recipe_ingredients values(3,0);
insert into recipe_ingredients values(3,2);
insert into recipe_ingredients values(3,1);
insert into coffee values(3,'cappucino lalacino','images/cappucino.png','cappucino',1,0,3);

--   Coffee Miel

insert into ingredient values(3,'black coffee',0.5);
insert into ingredient values(4,'honey',0.2);
insert into ingredient values(5,'cinnamon',0.8);
insert into recipe values(4,'coffee miel');
insert into recipe_ingredients values(4,3);
insert into recipe_ingredients values(4,4);
insert into recipe_ingredients values(4,5);
insert into recipe_ingredients values(4,2);
insert into coffee values(4,'coffee miel','images/coffeemiel.png','coffee miel',1.3,0,4);


