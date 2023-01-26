# Report for Americium Shrinking on "calculator"

This report was generated with Americium 1.8.2

The first report permits expressions to evaluate to zero by way of integer division truncation as well as by explicit zero constant terms.

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``Division(Constant(0),Addition(Constant(0),Constant(0)))`` - 5 seconds budget, repeated for each successive shrinkage cycle.

## Performance

18412 cases were run.

Failing cases...

0 - Shrinkage has found a failing case: Division(Constant(-532349377),Division(Constant(-326121969),Constant(1535144871))) after 42 trials including this one.
1 - Shrinkage has found a failing case: Division(Constant(-1176863010),Division(Constant(518374164),Constant(640720608))) after 1220 trials including this one.
2 - Shrinkage has found a failing case: Division(Constant(624694709),Division(Constant(-691444503),Constant(-719201348))) after 2205 trials including this one.
3 - Shrinkage has found a failing case: Division(Constant(390893619),Division(Constant(-59790059),Constant(843507446))) after 2371 trials including this one.
4 - Shrinkage has found a failing case: Division(Constant(472791216),Division(Constant(-63522270),Constant(501455262))) after 2374 trials including this one.
5 - Shrinkage has found a failing case: Division(Constant(142959677),Division(Constant(113614821),Constant(333074787))) after 2540 trials including this one.
6 - Shrinkage has found a failing case: Division(Constant(-213702807),Division(Constant(23836954),Constant(61041182))) after 2944 trials including this one.
7 - Shrinkage has found a failing case: Division(Constant(14624522),Division(Constant(5350017),Constant(78303377))) after 2955 trials including this one.
8 - Shrinkage has found a failing case: Division(Constant(23307313),Division(Constant(24365178),Constant(66202977))) after 3088 trials including this one.
9 - Shrinkage has found a failing case: Division(Constant(53041944),Division(Constant(3954453),Constant(-46782863))) after 3338 trials including this one.
10 - Shrinkage has found a failing case: Division(Constant(18010870),Division(Constant(18495228),Constant(22843340))) after 3342 trials including this one.
11 - Shrinkage has found a failing case: Division(Constant(-16521712),Division(Constant(5760954),Constant(6755874))) after 3507 trials including this one.
12 - Shrinkage has found a failing case: Division(Constant(9598113),Division(Constant(4547520),Constant(-5913294))) after 3559 trials including this one.
13 - Shrinkage has found a failing case: Division(Constant(-7859832),Division(Constant(-1556181),Constant(-2935214))) after 3688 trials including this one.
14 - Shrinkage has found a failing case: Division(Constant(4225747),Division(Constant(-1137643),Constant(1314040))) after 3988 trials including this one.
15 - Shrinkage has found a failing case: Division(Constant(2825764),Division(Constant(2027779),Constant(2844547))) after 4037 trials including this one.
16 - Shrinkage has found a failing case: Division(Constant(1106388),Division(Constant(1306408),Constant(-2346758))) after 4432 trials including this one.
17 - Shrinkage has found a failing case: Division(Constant(1095449),Division(Constant(-147077),Constant(-1192588))) after 4437 trials including this one.
18 - Shrinkage has found a failing case: Division(Constant(562668),Division(Constant(-547223),Constant(-971399))) after 4620 trials including this one.
19 - Shrinkage has found a failing case: Division(Constant(687528),Division(Constant(-179280),Constant(264846))) after 5326 trials including this one.
20 - Shrinkage has found a failing case: Division(Constant(-334198),Division(Constant(-334059),Constant(456297))) after 5593 trials including this one.
21 - Shrinkage has found a failing case: Division(Constant(-292894),Division(Constant(195504),Constant(272488))) after 5671 trials including this one.
22 - Shrinkage has found a failing case: Division(Constant(-166480),Division(Constant(-62950),Constant(165938))) after 6114 trials including this one.
23 - Shrinkage has found a failing case: Division(Constant(43009),Division(Constant(65264),Constant(96160))) after 6186 trials including this one.
24 - Shrinkage has found a failing case: Division(Constant(978),Division(Constant(-62730),Constant(65376))) after 6225 trials including this one.
25 - Shrinkage has found a failing case: Division(Constant(49660),Division(Constant(706),Constant(-23064))) after 6292 trials including this one.
26 - Shrinkage has found a failing case: Division(Constant(3075),Division(Constant(-30344),Constant(32124))) after 6347 trials including this one.
27 - Shrinkage has found a failing case: Division(Constant(-3107),Division(Constant(1482),Constant(-7385))) after 6436 trials including this one.
28 - Shrinkage has found a failing case: Division(Constant(3459),Division(Constant(-1764),Constant(2431))) after 11143 trials including this one.
29 - Shrinkage has found a failing case: Division(Constant(-1406),Division(Constant(2065),Constant(2828))) after 15047 trials including this one.
30 - Shrinkage has found a failing case: Division(Constant(861),Division(Constant(-1713),Constant(2874))) after 15941 trials including this one.
31 - Shrinkage has found a failing case: Division(Constant(2327),Division(Constant(-704),Constant(1228))) after 16315 trials including this one.
32 - Shrinkage has found a failing case: Division(Constant(-2001),Division(Constant(447),Constant(1086))) after 16346 trials including this one.
33 - Shrinkage has found a failing case: Division(Constant(-987),Division(Constant(-237),Constant(-1046))) after 16423 trials including this one.
34 - Shrinkage has found a failing case: Division(Constant(119),Division(Constant(-518),Constant(-522))) after 16488 trials including this one.
35 - Shrinkage has found a failing case: Division(Constant(589),Division(Constant(-89),Constant(106))) after 16748 trials including this one.
36 - Shrinkage has found a failing case: Division(Constant(-269),Division(Constant(100),Constant(-353))) after 16838 trials including this one.
37 - Shrinkage has found a failing case: Division(Constant(235),Division(Constant(-196),Constant(-239))) after 17028 trials including this one.
38 - Shrinkage has found a failing case: Division(Constant(76),Division(Constant(108),Constant(-146))) after 17047 trials including this one.
39 - Shrinkage has found a failing case: Division(Constant(66),Division(Constant(2),Constant(60))) after 17071 trials including this one.
40 - Shrinkage has found a failing case: Division(Constant(56),Division(Constant(29),Constant(-55))) after 17104 trials including this one.
41 - Shrinkage has found a failing case: Division(Constant(9),Division(Constant(6),Constant(-7))) after 17132 trials including this one.
42 - Shrinkage has found a failing case: Division(Constant(7),Addition(Constant(-3),Constant(3))) after 17564 trials including this one.
43 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(-5),Constant(-6))) after 17995 trials including this one.
44 - Shrinkage has found a failing case: Division(Constant(1),Division(Constant(3),Constant(6))) after 18081 trials including this one.
45 - Shrinkage has found a failing case: Division(Constant(-1),Addition(Constant(-4),Constant(4))) after 18300 trials including this one.
46 - Shrinkage has found a failing case: Division(Constant(-3),Division(Constant(1),Constant(3))) after 18308 trials including this one.
47 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(-1),Constant(3))) after 18334 trials including this one.
48 - Shrinkage has found a failing case: Division(Constant(1),Division(Constant(-1),Constant(-2))) after 18383 trials including this one.
49 - Shrinkage has found a failing case: Division(Constant(-1),Addition(Constant(1),Constant(-1))) after 18392 trials including this one.
50 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(0),Constant(0))) after 18410 trials including this one.
51 - Shrinkage has found a failing case: Division(Constant(0),Addition(Constant(0),Constant(0))) after 18412 trials including this one.
52 - Shrinkage has found a failing case: Division(Constant(0),Addition(Constant(0),Constant(0))) after 18412 trials including this one.

The second report uses `BigDecimal` to prevent trivial evaluation of zero by truncation, but still allows explicit zero constant terms.

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``Division(Constant(0),Division(Constant(0),Constant(1)))`` - 5 seconds budget, repeated for each successive shrinkage cycle.

## Performance

106514 cases were run.

Failing cases...

0 - Shrinkage has found a failing case: Addition(Constant(-728),Addition(Addition(Addition(Addition(Division(Constant(707),Addition(Constant(-826),Constant(820))),Division(Constant(-15),Addition(Constant(-295),Constant(295)))),Constant(-657)),Constant(485)),Constant(-959))) after 3825 trials including this one.
1 - Shrinkage has found a failing case: Division(Division(Constant(-463),Division(Constant(0),Constant(-166))),Constant(-482)) after 10479 trials including this one.
2 - Shrinkage has found a failing case: Division(Constant(-734),Division(Constant(0),Constant(569))) after 13272 trials including this one.
3 - Shrinkage has found a failing case: Division(Constant(-734),Division(Constant(0),Constant(569))) after 27153 trials including this one.
4 - Shrinkage has found a failing case: Division(Constant(166),Division(Constant(0),Constant(563))) after 27154 trials including this one.
5 - Shrinkage has found a failing case: Division(Constant(166),Division(Constant(0),Constant(563))) after 41465 trials including this one.
6 - Shrinkage has found a failing case: Division(Constant(132),Division(Constant(0),Constant(217))) after 41467 trials including this one.
7 - Shrinkage has found a failing case: Division(Constant(132),Division(Constant(0),Constant(217))) after 54165 trials including this one.
8 - Shrinkage has found a failing case: Division(Constant(12),Division(Constant(0),Constant(7))) after 54166 trials including this one.
9 - Shrinkage has found a failing case: Division(Constant(12),Division(Constant(0),Constant(7))) after 66822 trials including this one.
10 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(5))) after 66823 trials including this one.
11 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(5))) after 79446 trials including this one.
12 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(3))) after 79447 trials including this one.
13 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(3))) after 92836 trials including this one.
14 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(1))) after 92837 trials including this one.
15 - Shrinkage has found a failing case: Division(Constant(0),Division(Constant(0),Constant(1))) after 106509 trials including this one.

The third report uses `BigDecimal` and forbids the use of explicit zero constant terms.

## Normalization

Americium currently uses a fixed internal randomisation seed, so always yields the same shrinkage:

* ``Division(Constant(-1),Addition(Constant(-1),Constant(1)))`` - 5 seconds budget, repeated for each successive shrinkage cycle.

## Performance

131477 cases were run.

Failing cases...

0 - Shrinkage has found a failing case: Division(Division(Constant(-780),Constant(-46)),Addition(Constant(-231),Constant(231))) after 2278 trials including this one.
1 - Shrinkage has found a failing case: Division(Constant(885),Addition(Constant(-257),Constant(257))) after 8223 trials including this one.
2 - Shrinkage has found a failing case: Division(Constant(885),Addition(Constant(-257),Constant(257))) after 22139 trials including this one.
3 - Shrinkage has found a failing case: Division(Constant(23),Addition(Constant(-165),Constant(165))) after 22732 trials including this one.
4 - Shrinkage has found a failing case: Division(Constant(23),Addition(Constant(-165),Constant(165))) after 35008 trials including this one.
5 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-51),Constant(51))) after 35095 trials including this one.
6 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-51),Constant(51))) after 46622 trials including this one.
7 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-28),Constant(28))) after 46664 trials including this one.
8 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-28),Constant(28))) after 58530 trials including this one.
9 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-21),Constant(21))) after 58545 trials including this one.
10 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-21),Constant(21))) after 70438 trials including this one.
11 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-12),Constant(12))) after 70441 trials including this one.
12 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-12),Constant(12))) after 82713 trials including this one.
13 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-7),Constant(7))) after 82718 trials including this one.
14 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-7),Constant(7))) after 94902 trials including this one.
15 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-2),Constant(2))) after 94917 trials including this one.
16 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-2),Constant(2))) after 106713 trials including this one.
17 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-1),Constant(1))) after 106714 trials including this one.
18 - Shrinkage has found a failing case: Division(Constant(1),Addition(Constant(-1),Constant(1))) after 119038 trials including this one.
19 - Shrinkage has found a failing case: Division(Constant(-1),Addition(Constant(-1),Constant(1))) after 119040 trials including this one.
20 - Shrinkage has found a failing case: Division(Constant(-1),Addition(Constant(-1),Constant(1))) after 131476 trials including this one.
