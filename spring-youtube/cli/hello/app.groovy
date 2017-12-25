@RestController
class AppCtrl {
	@RequestMapping("/")
	String app() {
		"Hello Spring"
	}
}