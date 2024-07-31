
INSERT INTO unit (unit_name_singular, unit_name_plural) VALUES
    ('teaspoon', 'teaspoons'),
    ('tablespoon', 'tablespoons'),
    ('cup', 'cups'),
    ('ounce', 'ounces'),
    ('pound', 'pounds'),
    ('gram', 'grams'),
    ('milliliter', 'milliliters'),
    ('small', 'small'),
    ('container', 'containers'),
    ('large', 'large');


INSERT INTO category (category_name) VALUES
    ('Asian'), ('Beef'), ('Smoker'), ('Bread'), ('Breakfast'),
    ('Fish and Seafood'), ('Italian'), ('Kid Food'), ('Low Carb'),
    ('Main Dish'), ('Mediterranean'), ('Mexican'), ('Pork'),
    ('Poultry'), ('Salad'), ('Sandwiches and Wraps'), ('Sauces and Rubs'),
    ('Side Dish'), ('Slow Cooker'), ('Soup'), ('Tex-Mex'),
    ('Vegetarian'), ('Veggies'), ('Fruit');


INSERT INTO recipe (recipe_name, notes, num_servings, prep_time, cook_time) VALUES
    ('Kitty Litter Cake', 'This kitty litter cake recipe has been around for quite a few years. If you want some gross Halloween party food, the kitty litter cake is always a hit!', 40, '00:20', '00:50'),
    ('Apple Monsters', 'These silly apple monsters make for a healthy snack any time of year', 4, '00:20', '00:00'),
    ('Ice Cubes', 'I\'m publishing this recipe because I\'m sure that there are other families who have members, who don\'t know how or have forgotten how to make ice when the ice tray is empty.', 4, '00:05', '06:00'),
    ('Chocolate Moose', 'This nontraditional dessert will require a slightly larger refrigerator. This is for VERY special occasions only — it takes a lot of effort, but the presentation is spectacular!', 4, '23:59', '23:59');


INSERT INTO ingredient (recipe_id, unit_id, ingredient_name, instruction, ingredient_order, amount) VALUES
    (1, 4, 'chocolate cake mix', null, 1, 16.25),
    (1, 4, 'yellow cake mix', null, 2, 16.25),
    (1, 4, 'vanilla instant pudding mix', null, 3, 5.1),
    (1, 4, 'vanilla sandwich cookies', null, 4, 25),
    (1, null, 'green food coloring', null, 5, null),
    (1, 8, 'Tootsie Rolls', null, 6, 15),
    (1, null, 'new kitty litter pan', null, 7, 1),
    (1, null, 'new Pooper Scooper', null, 8, 1),
    (2, null, 'green apple', 'cut in quarters', 1, 1),
    (2, 2, 'creamy peanut butter', null, 2, 2),
    (2, null, 'strawberries', 'cut in half', 3, 2),
    (2, null, 'sunflower seeds', null, 4, null),
    (2, null, 'edible candy eyes', null, 5, 8),
    (3, 3, 'water', 'approximately', 1, 2),
    (3, 2, 'water', 'if needed', 2, 2),
    (4, null, 'moose', null, 1, 1),
    (4, 5, 'Hershey\'s chocolate', null, 2, 40),
    (4, 9, 'Cool Whip', null, 3, 17),
    (4, null, 'cherry', null, 4, 1);


INSERT INTO step (recipe_id, step_order, step_text) VALUES
    (1, 1, 'Prepare cake mixes and bake according to directions (any size pans but 13\'d79 is easiest). Prepare pudding mix and chill until ready to assemble. Crumble sandwich cookies in small batches in food processor, scraping often. Set aside all but about 1/4 cup. To the 1/4 cup cookie crumbs, add a few drops green food coloring and mix using fingers until an even green color.'),
    (1, 2, 'When cakes are cooled to room temperature, crumble into the new litter box. Toss with half the remaining cookie crumbs and the chilled pudding. Mix in just enough of the pudding to moisten it.'),
    (1, 3, 'You don\'92t want it soggy. Combine gently.'),
    (1, 4, 'Put three unwrapped Tootsie rolls in a microwave safe dish and heat until soft and pliable. Shape ends so they are no longer blunt, curving slightly. Repeat with 3 more Tootsie rolls and bury in mixture. Sprinkle the other half of cookie crumbs over top.'),
    (1, 5, 'Scatter the green cookie crumbs lightly over the top. (This is supposed to look like the chlorophyll in kitty litter.) Heat 3 Tootsie Rools in the microwave until almost melted. Scrape them on top of the cake. Sprinkle with cookie crumbs. Spread remaining Tootsie Rolls over the top. Take one and heat until pliable. Hang it over the side of the kitty litter box, sprinkling it lightly with cookie crumbs. Serve with new pooper scooper.'),
    (2, 1, 'Cut the apple into quarters.'),
    (2, 2, 'Lay the apple quarters down, and cut a 1 inch wedge in the middle of the peel side of each quarter. Do not cut all the way through because you want each quarter to stay in one piece. It will look like a mouth.'),
    (2, 3, 'Cut the strawberries in slices lengthwise so that you have 4 pieces.'),
    (2, 4, 'Spread peanut butter on the bottom of each mouth, inside the cutout.'),
    (2, 5, 'Place a strawberry inside the cutout to resemble a tongue sticking out.'),
    (2, 6, 'Poke 6 or 7 sunflower seeds or almond slivers into the top edge of the cut out to resemble teeth.'),
    (2, 7, 'Serve right away!'),
    (3, 1, 'Empty the ice cubes that are left in the trays (if there are any left) into the bin.'),
    (3, 2, 'Take the trays over to the sink and fill them with cold water. (Hot water will freeze faster and more clear).'),
    (3, 3, 'Place the water filled ice trays back in the freezer.'),
    (3, 4, 'Replace the ice bin if you had to remove it.'),
    (3, 5, 'Shut the door to the freezer.'),
    (3, 6, 'Be sure to leave for around 4-6 hours at least to make sure it is frozen.'),
    (3, 7, 'If you want to experiment, you can freeze things like fruit infused waters or juices.'),
    (4, 1, 'Send spouse to Alaska to capture moose, or have one delivered by UPS.'),
    (4, 2, 'Meanwhile, melt chocolate in very large double boiler.'),
    (4, 3, 'Keep warm.'),
    (4, 4, 'Tie up moose with rope.'),
    (4, 5, 'Holding the moose by the tail, carefully dip in melted chocolate, covering it completely with a thin coating.'),
    (4, 6, 'Arrange moose attractively on large platter and refrigerate for 2 days to set chocolate.'),
    (4, 7, 'Remove rope, wash to remove chocolate, if necessary, and return rope to clothesline.'),
    (4, 8, 'Garnish chocolate moose with Cool Whip and top with a cherry.'),
    (4, 9, 'Serve immediately.'),
    (4, 10, 'Or you could just chew on the rope, which may be tastier.'),
    (4, 11, 'May be doubled for serving a crowd.');


INSERT INTO recipe_category (recipe_id, category_id) VALUES
    (1, 4),
    (1, 8),
    (1, 18),
    (1, 22),
    (2, 8),
    (2, 18),
    (2, 22),
    (2, 24),
    (3, 22),
    (4, 10);