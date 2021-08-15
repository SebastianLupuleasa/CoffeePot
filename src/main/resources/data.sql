
-- Address

 insert into address values(990,12,'Strada Soarelui');

-- Carts

insert into cart values(990,0);
insert into cart values(991,0);

-- Users

 insert into customer values (990,'password','ROLE_ADMIN','lupuleasa',990,990);
 insert into customer values (991,'password','ROLE_USER','ion',990,991);

-- Menu:

-- Espressso

 insert into ingredient values(990,'espresso',0.5,10);
 insert into recipe values(990,'espresso');
 insert into recipe_ingredients values(990,990);
 insert into coffee values(990,'espresso fast','images/espresso.png','espresso',990,990);

-- Machiatto

insert into ingredient values(991,'milk foam',0.2,10);
insert into recipe values(991,'machiatto');
insert into recipe_ingredients values(991,990);
insert into recipe_ingredients values(991,991);
insert into coffee values(991,'machiatto is good','images/machiatto.png','machiatto',990,991);

-- Coffee Latte

insert into ingredient values(992,'steamed milk',0.3,2);
insert into recipe values(992,'coffee latte');
insert into recipe_ingredients values(992,990);
insert into recipe_ingredients values(992,992);
insert into recipe_ingredients values(992,991);
insert into coffee values(992,'coffee latte i see','images/coffeelatte.png','coffee latte',990,992);

--   Cappuccino
insert into recipe values(993,'cappucino');
insert into recipe_ingredients values(993,990);
insert into recipe_ingredients values(993,992);
insert into recipe_ingredients values(993,991);
insert into coffee values(993,'cappucino lalacino','images/cappucino.png','cappucino',990,993);

--   Coffee Miel

insert into ingredient values(993,'black coffee',0.5,3);
insert into ingredient values(994,'honey',0.2,4);
insert into ingredient values(995,'cinnamon',0.8,2);
insert into recipe values(994,'coffee miel');
insert into recipe_ingredients values(994,993);
insert into recipe_ingredients values(994,994);
insert into recipe_ingredients values(994,995);
insert into recipe_ingredients values(994,992);
insert into coffee values(994,'coffee miel','images/coffeemiel.png','coffee miel',990,994);