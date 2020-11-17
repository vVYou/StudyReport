package studyreport.fodmap;

public enum FodmapCSVDescription {
	numero_d_identification(0, AnswerType.ID, new FodmapGroup[]{}, ""),
	diet_1(1, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_2(2, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_3(3, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_4(4, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_5(5, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_6(6, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_7(7, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_8(8, AnswerType.DIET, new FodmapGroup[]{}, ""),
	diet_food_999_a(9, AnswerType.OTHER, new FodmapGroup[]{}, ""),
	diet_food_999_b(10, AnswerType.OTHER, new FodmapGroup[]{}, ""),
	diet_food_a_001(11, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Semoule de blé (couscous), ou boulghour de blé"),
	diet_food_a_002(12, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Son de blé"),
	diet_food_a_003(13, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.FRUCTOSE},
					"Pain/ baguette à base de farine de blé ou de froment (blanc ou complet)"),
	diet_food_a_004(14, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Biscottes (à base de farine de blé)"),
	diet_food_a_005(15, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pain/ baguette à base de farine de seigle"),
	diet_food_a_006(16, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Corn flakes"),
	diet_food_a_007(17, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pâtes (à base de farine de blé)"),
	diet_food_a_008(18, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Artichaut"),
	diet_food_a_009(19, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Asperge"),
	diet_food_a_010(20, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Betterave"),
	diet_food_a_011(21, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Brocolis"),
	diet_food_a_012(22, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Choux de Bruxelles"),
	diet_food_a_013(23, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Butternut"),
	diet_food_a_014(24, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Choux "),
	diet_food_a_015(25, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Chou rouge"),
	diet_food_a_016(26, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Chou-fleur"),
	diet_food_a_017(27, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Poivron VERT"),
	diet_food_a_018(28, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Céleri rave"),
	diet_food_a_019(29, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Céleri (branches)"),
	diet_food_a_020(30, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Maïs en boite"),
	diet_food_a_021(31, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Aubergine"),
	diet_food_a_022(32, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Fenouil"),
	diet_food_a_023(33, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ail"),
	diet_food_a_024(34, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Poireaux"),
	diet_food_a_025(35, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Pois mange-tout"),
	diet_food_a_026(36, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Champignons"),
	diet_food_a_027(37, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Echalotes"),
	diet_food_a_028(38, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Oignons rouges ou blanc"),
	diet_food_a_029(39, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Petits pois"),
	diet_food_a_030(40, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Navets"),
	diet_food_a_031(41, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Patate douce"),
	diet_food_a_032(42, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Tomates séchées"),
	diet_food_a_033(43, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Haricots rouges"),
	diet_food_a_034(44, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Haricots blancs"),
	diet_food_a_035(45, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Pois chiches"),
	diet_food_a_036(46, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Falafels"),
	diet_food_a_037(47, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Pois cassé"),
	diet_food_a_038(48, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pommes séchées"),
	diet_food_a_039(49, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pomme"),
	diet_food_a_040(50, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Abricots"),
	diet_food_a_041(51, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Jus d’abricot"),
	diet_food_a_042(52, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Abricots séchés"),
	diet_food_a_043(53, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Avocat"),
	diet_food_a_044(54, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Bananes séchées"),
	diet_food_a_045(55, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Mûre"),
	diet_food_a_046(56, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Myrtilles"),
	diet_food_a_047(57, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Cerises"),
	diet_food_a_048(58, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Noix de coco séchée"),
	diet_food_a_049(59, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Cranberries séchés"),
	diet_food_a_050(60, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Dattes"),
	diet_food_a_051(61, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Figues"),
	diet_food_a_052(62, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Baies de goji"),
	diet_food_a_053(63, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pamplemousse"),
	diet_food_a_054(64, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Pastèque"),
	diet_food_a_055(65, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Framboises"),
	diet_food_a_056(66, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Raisins secs"),
	diet_food_a_057(67, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Grenade"),
	diet_food_a_058(68, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Prune"),
	diet_food_a_059(69, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ananas séché"),
	diet_food_a_060(70, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Kaki"),
	diet_food_a_061(71, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE, FodmapGroup.POLYOLS}, "Poire"),
	diet_food_a_062(72, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Pêche"),
	diet_food_a_063(73, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Fruit de la passion"),
	diet_food_a_064(74, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.POLYOLS}, "Nectarine"),
	diet_food_a_065(75, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Melon vert"),
	diet_food_a_066(76, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Mangue"),
	diet_food_a_067(77, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Mangue séchée"),
	diet_food_a_068(78, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Lychee"),
	diet_food_a_069(79, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Jus de multifruit"),
	diet_food_a_070(80, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Sirop d’agave"),
	diet_food_a_071(81, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Sirop de liège/ sirop de pommes-poire"),
	diet_food_a_072(82, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Chocolat noir"),
	diet_food_a_073(83, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Chocolat blanc"),
	diet_food_a_074(84, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Chocolat au lait"),
	diet_food_a_075(85, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Bonbons"),
	diet_food_a_076(86, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Miel"),
	diet_food_a_077(87, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "Sucre de coco"),
	diet_food_a_078(88, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES, FodmapGroup.POLYOLS}, "Houmous"),
	diet_food_a_079(89, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Confitures lights"),
	diet_food_a_080(90, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Ketchup"),
	diet_food_a_081(91, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Pickels (cornichons)"),
	diet_food_a_082(92, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Cookies"),
	diet_food_a_083(93, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Sablés"),
	diet_food_a_084(94, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Amandes"),
	diet_food_a_085(95, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Noix de cajou"),
	diet_food_a_086(96, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Pistaches"),
	diet_food_a_087(97, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "Rhum"),
	diet_food_a_088(98, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Edulcorants (« faux-sucre »)"),
	diet_food_a_089(99, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.POLYOLS}, "Soda lights"),
	diet_food_a_090(100, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "SODA"),
	diet_food_a_091(101, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Complément nutritionnel oral"),
	diet_food_a_092(102, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Fromage blanc"),
	diet_food_a_093(103, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Cottage cheese"),
	diet_food_a_094(104, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Ricotta"),
	diet_food_a_095(105, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Crème"),
	diet_food_a_096(106, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Crème glacée"),
	diet_food_a_097(107, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Kéfir"),
	diet_food_a_098(108, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Lait de coco"),
	diet_food_a_099(109, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Lait (vache ou chèvre)"),
	diet_food_a_100(110, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "Lait d’avoine"),
	diet_food_a_101(111, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "Lait de soja"),
	diet_food_a_102(112, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Yaourt au lait de vache"),
	diet_food_a_103(113, AnswerType.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "Tofu soyeux");

	private final int columnId;
	private final AnswerType type;
	private final FodmapGroup[] groups;
	private final String frenchTranslation;

	FodmapCSVDescription(int columnId, AnswerType type, FodmapGroup[] groups, String frenchTranslation) {
		this.columnId = columnId;
		this.type = type;
		this.groups = groups;
		this.frenchTranslation = frenchTranslation;
	}

	public int getColumnId() {
		return columnId;
	}

	public AnswerType getType() {
		return type;
	}

	public FodmapGroup[] getGroups() {
		return groups;
	}

	public String getFrenchTranslation() {
		return frenchTranslation;
	}
}
