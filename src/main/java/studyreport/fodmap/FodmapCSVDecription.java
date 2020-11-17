package studyreport.fodmap;

public enum FodmapCSVDecription {
	numero_d_identification(0, FodmapAnswer.ID, new FodmapGroup[]{}, ""),
	diet_1(1, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_2(2, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_3(3, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_4(4, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_5(5, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_6(6, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_7(7, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_8(8, FodmapAnswer.DIET, new FodmapGroup[]{}, ""),
	diet_food_999_a(9, FodmapAnswer.OTHER, new FodmapGroup[]{}, ""),
	diet_food_999_b(10, FodmapAnswer.OTHER, new FodmapGroup[]{}, ""),
	diet_food_a_001(11, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Semoule de blé (couscous), ou boulghour de blé"),
	diet_food_a_002(12, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Son de blé"),
	diet_food_a_003(13, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.FRUCTOSE},
					"Pain/ baguette à base de farine de blé ou de froment (blanc ou complet)"),
	diet_food_a_004(14, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Biscottes (à base de farine de blé)"),
	diet_food_a_005(15, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pain/ baguette à base de farine de seigle"),
	diet_food_a_006(16, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Corn flakes"),
	diet_food_a_007(17, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pâtes (à base de farine de blé)"),
	diet_food_a_008(18, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Artichaut"),
	diet_food_a_009(19, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Asperge"),
	diet_food_a_010(20, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Betterave"),
	diet_food_a_011(21, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Brocolis"),
	diet_food_a_012(22, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Choux de Bruxelles"),
	diet_food_a_013(23, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Butternut"),
	diet_food_a_014(24, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Choux "),
	diet_food_a_015(25, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Chou rouge"),
	diet_food_a_016(26, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Chou-fleur"),
	diet_food_a_017(27, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Poivron VERT"),
	diet_food_a_018(28, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Céleri rave"),
	diet_food_a_019(29, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Céleri (branches)"),
	diet_food_a_020(30, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Maïs en boite"),
	diet_food_a_021(31, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Aubergine"),
	diet_food_a_022(32, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Fenouil"),
	diet_food_a_023(33, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ail"),
	diet_food_a_024(34, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Poireaux"),
	diet_food_a_025(35, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Pois mange-tout"),
	diet_food_a_026(36, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Champignons"),
	diet_food_a_027(37, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Echalotes"),
	diet_food_a_028(38, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Oignons rouges ou blanc"),
	diet_food_a_029(39, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Petits pois"),
	diet_food_a_030(40, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Navets"),
	diet_food_a_031(41, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Patate douce"),
	diet_food_a_032(42, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Tomates séchées"),
	diet_food_a_033(43, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Haricots rouges"),
	diet_food_a_034(44, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Haricots blancs"),
	diet_food_a_035(45, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Pois chiches"),
	diet_food_a_036(46, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Falafels"),
	diet_food_a_037(47, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Pois cassé"),
	diet_food_a_038(48, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pommes séchées"),
	diet_food_a_039(49, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pomme"),
	diet_food_a_040(50, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Abricots"),
	diet_food_a_041(51, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Jus d’abricot"),
	diet_food_a_042(52, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Abricots séchés"),
	diet_food_a_043(53, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Avocat"),
	diet_food_a_044(54, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Bananes séchées"),
	diet_food_a_045(55, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Mûre"),
	diet_food_a_046(56, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Myrtilles"),
	diet_food_a_047(57, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Cerises"),
	diet_food_a_048(58, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Noix de coco séchée"),
	diet_food_a_049(59, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Cranberries séchés"),
	diet_food_a_050(60, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Dattes"),
	diet_food_a_051(61, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Figues"),
	diet_food_a_052(62, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Baies de goji"),
	diet_food_a_053(63, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pamplemousse"),
	diet_food_a_054(64, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pastèque"),
	diet_food_a_055(65, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Framboises"),
	diet_food_a_056(66, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Raisins secs"),
	diet_food_a_057(67, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Grenade"),
	diet_food_a_058(68, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Prune"),
	diet_food_a_059(69, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ananas séché"),
	diet_food_a_060(70, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Kaki"),
	diet_food_a_061(71, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Poire"),
	diet_food_a_062(72, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Pêche"),
	diet_food_a_063(73, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Fruit de la passion"),
	diet_food_a_064(74, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Nectarine"),
	diet_food_a_065(75, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Melon vert"),
	diet_food_a_066(76, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Mangue"),
	diet_food_a_067(77, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Mangue séchée"),
	diet_food_a_068(78, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Lychee"),
	diet_food_a_069(79, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Jus de multifruit"),
	diet_food_a_070(80, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Sirop d’agave"),
	diet_food_a_071(81, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Sirop de liège/ sirop de pommes-poire"),
	diet_food_a_072(82, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Chocolat noir"),
	diet_food_a_073(83, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Chocolat blanc"),
	diet_food_a_074(84, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Chocolat au lait"),
	diet_food_a_075(85, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Bonbons"),
	diet_food_a_076(86, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Miel"),
	diet_food_a_077(87, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Sucre de coco"),
	diet_food_a_078(88, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Houmous"),
	diet_food_a_079(89, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Confitures lights"),
	diet_food_a_080(90, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ketchup"),
	diet_food_a_081(91, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pickels (cornichons)"),
	diet_food_a_082(92, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Cookies"),
	diet_food_a_083(93, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Sablés"),
	diet_food_a_084(94, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Amandes"),
	diet_food_a_085(95, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Noix de cajou"),
	diet_food_a_086(96, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Pistaches"),
	diet_food_a_087(97, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Rhum"),
	diet_food_a_088(98, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Edulcorants (« faux-sucre »)"),
	diet_food_a_089(99, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Soda lights"),
	diet_food_a_090(100, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "SODA"),
	diet_food_a_091(101, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Complément nutritionnel oral"),
	diet_food_a_092(102, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Fromage blanc"),
	diet_food_a_093(103, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Cottage cheese"),
	diet_food_a_094(104, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Ricotta"),
	diet_food_a_095(105, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Crème"),
	diet_food_a_096(106, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Crème glacée"),
	diet_food_a_097(107, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Kéfir"),
	diet_food_a_098(108, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Lait de coco"),
	diet_food_a_099(109, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Lait (vache ou chèvre)"),
	diet_food_a_100(110, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Lait d’avoine"),
	diet_food_a_101(111, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Lait de soja"),
	diet_food_a_102(112, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Yaourt au lait de vache"),
	diet_food_a_103(113, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Tofu soyeux");

	private final int columnId;
	private final FodmapAnswer type;
	private final FodmapGroup[] groups;
	private final String frenchTranslation;

	FodmapCSVDecription(int columnId, FodmapAnswer type, FodmapGroup[] groups, String frenchTranslation) {
		this.columnId = columnId;
		this.type = type;
		this.groups = groups;
		this.frenchTranslation = frenchTranslation;
	}

	public int getColumnId() {
		return columnId;
	}

	public FodmapAnswer getType() {
		return type;
	}

	public FodmapGroup[] getGroups() {
		return groups;
	}

	public String getFrenchTranslation() {
		return frenchTranslation;
	}
}
