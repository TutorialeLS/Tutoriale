package app;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Zadanie {
	public static void main(String[] args) {
		String str = ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hoc autem tempore, etsi multa in omni parte Athenarum sunt in ipsis locis indicia summorum virorum, tamen ego illa moveor exhedra. Et nunc quidem quod eam tuetur, ut de vite potissimum loquar, est id extrinsecus; Duo Reges: constructio interrete. Quin etiam ferae, inquit Pacuvius, quebus abest, ad pravcavendum intellegendi astetia, iniecto terrore mortis horrescunt. Omnem vim loquendi, ut iam ante Aristoteles, in duas tributam esse partes, rhetoricam palmae, dialecticam pugni similem esse dicebat, quod latius loquerentur rhetores, dialectici autem compressius. Si alia sentit, inquam, alia loquitur, numquam intellegam quid sentiat; Hic si Peripateticus fuisset, permansisset, credo, in sententia, qui dolorem malum dicunt esse, de asperitate autem eius fortiter ferenda praecipiunt eadem, quae Stoici. Nec vero potest quisquam de bonis et malis vere iudicare nisi omni cognita ratione naturae et vitae etiam deorum, et utrum conveniat necne natura hominis cum universa. Atque hoc loco similitudines eas, quibus illi uti solent, dissimillimas proferebas. Cur id non ita fit? Hic quoque suus est de summoque bono dissentiens dici vere Peripateticus non potest. Semovenda est igitur voluptas, non solum ut recta sequamini, sed etiam ut loqui deceat frugaliter.\r\n"
				+ "\r\n"
				+ "Ex quo intellegi debet homini id esse in bonis ultimum, secundum naturam vivere, quod ita interpretemur: vivere ex hominis natura undique perfecta et nihil requirente. Septem autem illi non suo, sed populorum suffragio omnium nominati sunt. Is cum arderet podagrae doloribus visitassetque hominem Charmides Epicureus perfamiliaris et tristis exiret, Mane, quaeso, inquit, Charmide noster; In omni enim arte vel studio vel quavis scientia vel in ipsa virtute optimum quidque rarissimum est. Neque enim in aliqua parte, sed in perpetuitate temporis vita beata dici solet, nec appellatur omnino vita, nisi confecta atque absoluta, nec potest quisquam alias beatus esse, alias miser; Quae enim mala illi non audent appellare, aspera autem et incommoda et reicienda et aliena naturae esse concedunt, ea nos mala dicimus, sed exigua et paene minima. Graecum enim hunc versum nostis omnes-: Suavis laborum est praeteritorum memoria. Quid enim est tam repugnans quam eundem dicere, quod honestum sit, solum id bonum esse, qui dicat appetitionem rerum ad vivendum accommodatarum natura profectam? Me quidem ad altiorem memoriam Oedipodis huc venientis et illo mollissimo carmine quaenam essent ipsa haec loca requirentis species quaedam commovit, inaniter scilicet, sed commovit tamen. Quid turpius quam sapientis vitam ex insipientium sermone pendere? Quos qui tollunt et nihil posse percipi dicunt, ii remotis sensibus ne id ipsum quidem expedire possunt, quod disserunt. Perturbationes autem nulla naturae vi commoventur, omniaque ea sunt opiniones ac iudicia levitatis. \r\n"
				+ "\r\n"
				+ "Quod et posse fieri intellegimus et saepe etiam videmus, et perspicuum est nihil ad iucunde vivendum reperiri posse, quod coniunctione tali sit aptius. Nemo nostrum credebat, eratque veri similius hunc mentiri, cuius interesset, quam illum, qui id se rogasse scripsisset, quod debuisset rogare. Completur enim et ex eo genere vitae, quod virtute fruitur, et ex iis rebus, quae sunt secundum naturam neque sunt in nostra potestate. Si ad corpus pertinentibus, rationes tuas te video compensare cum istis doloribus, non memoriam corpore perceptarum voluptatum; Qui et definierunt plurima et definiendi artes reliquerunt, quodque est definitioni adiunctum, ut res in partes dividatur, id et fit ab illis et quem ad modum fieri oporteat traditur; In quibus hoc primum est in quo admirer, cur in gravissimis rebus non delectet eos sermo patrius, cum idem fabellas Latinas ad verbum e Graecis expressas non inviti legant. Idque si ita dicit, non esse reprehendendos luxuriosos, si sapientes sint, dicit absurde, similiter et si dicat non reprehendendos parricidas, si nec cupidi sint nec deos metuant nec mortem nec dolorem. Sin laboramus, quis est, qui alienae modum statuat industriae? Voluptatis causa, etiam si eam non consequare, aut non dolendi, etiam si id assequi nequeas, aut eorum, quae secundum naturam sunt, adipiscendi, etiam si nihil consequare. Quo modo autem optimum, si bonum praeterea nullum est? At vero Epicurus una in domo, et ea quidem angusta, quam magnos quantaque amoris conspiratione consentientis tenuit amicorum greges! quod fit etiam nunc ab Epicureis. Id autem eius modi est, ut additum ad virtutem auctoritatem videatur habiturum et expleturum cumulate vitam beatam, de quo omnis haec quaestio est. \r\n"
				+ "\r\n"
				+ "Quia, cum a Zenone, inquam, hoc magnifice tamquam ex oraculo editur: Virtus ad beate vivendum se ipsa contenta est, et Quare? Hoc est vim afferre, Torquate, sensibus, extorquere ex animis cognitiones verborum, quibus inbuti sumus. Si sapiens, ne tum quidem miser, cum ab Oroete, praetore Darei, in crucem actus est. Nam hunc ipsum sive finem sive extremum sive ultimum definiebas id esse, quo omnia, quae recte fierent, referrentur neque id ipsum usquam referretur.\r\n"
				+ "\r\n"
				+ "Nunc vero, quoniam haec nos etiam tractare coepimus, suppeditabit nobis Atticus noster e thesauris suis quos et quantos viros! nonne melius est de his aliquid quam tantis voluminibus de Themista loqui? Equidem etiam curiam nostram-Hostiliam dico, non hanc novam, quae minor mihi esse videtur, posteaquam est maior-solebam intuens Scipionem, Catonem, Laelium, nostrum vero in primis avum cogitare; Quam multa vitiosa! summum enim bonum et malum vagiens puer utra voluptate diiudicabit, stante an movente? Honestum igitur id intellegimus, quod tale est, ut detracta omni utilitate sine ullis praemiis fructibusve per se ipsum possit iure laudari. Sin eam, quam Hieronymus, ne fecisset idem, ut voluptatem illam Aristippi in prima commendatione poneret. Quod si ita est, sequitur id ipsum, quod te velle video, omnes semper beatos esse sapientes. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint et molestiae non recusandae. Verum esto: verbum ipsum voluptatis non habet dignitatem, nec nos fortasse intellegimus. Ad quorum et cognitionem et usum iam corroborati natura ipsa praeeunte deducimur. Amicitiam autem adhibendam esse censent, quia sit ex eo genere, quae prosunt. Hic homo severus luxuriam ipsam per se reprehendendam non putat, et hercule, Torquate, ut verum loquamur, si summum bonum voluptas est, rectissime non putat.");
		String[] strTab = str.split(" ");
		List<String> strList = Arrays.asList(strTab);
		strList = strList.stream()
				.filter(x -> x.startsWith("s"))
				.filter(x -> x.length() <= 5)
				.map(new Function<String, String>() {
					@Override
					public String apply(String arg0) {
						return arg0.replaceAll(",", "").replaceAll("\\.", "");
					}
				})
				.collect(Collectors.toList());
		strList.forEach(x -> System.out.println(x + " "));
		long sWords = strList.stream().filter(x -> x.length() <= 5).count();
		
		System.out.println(sWords);
		
		long words5 = strList.stream()
				.filter(x -> x.startsWith("s"))
				.count();
		
		System.out.println(words5);
		
	}
}