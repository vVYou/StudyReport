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
	diet_food_a_008(18, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tArtichaut"),
	diet_food_a_009(19, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "o\tAsperge"),
	diet_food_a_010(20, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tBetterave"),
	diet_food_a_011(21, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tBrocolis"),
	diet_food_a_012(22, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tChoux de Bruxelles"),
	diet_food_a_013(23, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tButternut"),
	diet_food_a_014(24, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_015(25, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tChou rouge"),
	diet_food_a_016(26, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_017(27, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_018(28, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_019(29, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_020(30, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tMaïs en boite"),
	diet_food_a_021(31, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_022(32, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tFenouil"),
	diet_food_a_023(33, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tAil"),
	diet_food_a_024(34, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tPoireaux"),
	diet_food_a_025(35, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tPois mange-tout"),
	diet_food_a_026(36, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tChampignons"),
	diet_food_a_027(37, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tEchalotes"),
	diet_food_a_028(38, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tOignons rouges ou blanc"),
	diet_food_a_029(39, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tPetits pois"),
	diet_food_a_030(40, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_031(41, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_032(42, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tTomates séchées"),
	diet_food_a_033(43, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tHaricots rouges"),
	diet_food_a_034(44, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tHaricots blancs"),
	diet_food_a_035(45, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tPois chiches"),
	diet_food_a_036(46, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tFalafels"),
	diet_food_a_037(47, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tPois cassé"),
	diet_food_a_038(48, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tPommes séchées"),
	diet_food_a_039(49, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tPomme"),
	diet_food_a_040(50, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tAbricots"),
	diet_food_a_041(51, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_042(52, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tAbricots séchés"),
	diet_food_a_043(53, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_044(54, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tBananes séchées"),
	diet_food_a_045(55, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_046(56, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tMyrtilles"),
	diet_food_a_047(57, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tCerises"),
	diet_food_a_048(58, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_049(59, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tCranberries séchés"),
	diet_food_a_050(60, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tDattes"),
	diet_food_a_051(61, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tFigues"),
	diet_food_a_052(62, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tBaies de goji"),
	diet_food_a_053(63, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tPamplemousse"),
	diet_food_a_054(64, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "o\tPastèque"),
	diet_food_a_055(65, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tFramboises"),
	diet_food_a_056(66, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tRaisins secs"),
	diet_food_a_057(67, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tGrenade"),
	diet_food_a_058(68, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tPrune"),
	diet_food_a_059(69, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tAnanas séché"),
	diet_food_a_060(70, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tKaki"),
	diet_food_a_061(71, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tPoire"),
	diet_food_a_062(72, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_063(73, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tFruit de la passion"),
	diet_food_a_064(74, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tNectarine"),
	diet_food_a_065(75, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tMelon vert"),
	diet_food_a_066(76, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tMangue"),
	diet_food_a_067(77, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tMangue séchée"),
	diet_food_a_068(78, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_069(79, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tJus de multifruit"),
	diet_food_a_070(80, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tSirop d’agave"),
	diet_food_a_071(81, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tSirop de liège/ sirop de pommes-poire"),
	diet_food_a_072(82, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tChocolat noir"),
	diet_food_a_073(83, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tChocolat blanc"),
	diet_food_a_074(84, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tChocolat au lait"),
	diet_food_a_075(85, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "o\tBonbons"),
	diet_food_a_076(86, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tMiel"),
	diet_food_a_077(87, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.FRUCTOSE}, "o\tSucre de coco"),
	diet_food_a_078(88, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tHoumous"),
	diet_food_a_079(89, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_080(90, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tKetchup"),
	diet_food_a_081(91, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tPickels (cornichons)"),
	diet_food_a_082(92, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tCookies"),
	diet_food_a_083(93, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tSablés"),
	diet_food_a_084(94, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tAmandes"),
	diet_food_a_085(95, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tNoix de cajou"),
	diet_food_a_086(96, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tPistaches"),
	diet_food_a_087(97, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tRhum"),
	diet_food_a_088(98, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_089(99, FodmapAnswer.FOOD, new FodmapGroup[]{}, ""),
	diet_food_a_090(100, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTOSE}, "o\tSODA"),
	diet_food_a_091(101, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tComplément nutritionnel oral"),
	diet_food_a_092(102, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tFromage blanc"),
	diet_food_a_093(103, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tCottage cheese"),
	diet_food_a_094(104, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tRicotta"),
	diet_food_a_095(105, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tCrème"),
	diet_food_a_096(106, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tCrème glacée"),
	diet_food_a_097(107, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "Kéfir"),
	diet_food_a_098(108, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tLait de coco"),
	diet_food_a_099(109, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tLait (vache ou chèvre)"),
	diet_food_a_100(110, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES}, "o\tLait d’avoine"),
	diet_food_a_101(111, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.GLACTANES}, "o\tLait de soja"),
	diet_food_a_102(112, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.LACTOSE}, "o\tYaourt au lait de vache"),
	diet_food_a_103(113, FodmapAnswer.FOOD, new FodmapGroup[]{FodmapGroup.FRUCTANES, FodmapGroup.GLACTANES}, "o\tTofu soyeux");

	private final int columnId;
	private final FodmapAnswer type; //freeText, DietFood, ?
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
