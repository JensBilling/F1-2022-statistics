package se.iths.f12022statistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.entity.Team;
import se.iths.f12022statistics.service.BossService;

@RestController
@RequestMapping("api/bosses")
public class BossController {

    private final BossService bossService;

    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @PostMapping("")
    public ResponseEntity<Boss> addNewBoss(@RequestBody Boss boss) {
        bossService.addNewBoss(boss);
        return ResponseEntity.ok(boss);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Boss>> getAllBosses() {
        return ResponseEntity.ok(bossService.getAllBosses());
    }

    @GetMapping("{id}")
    public ResponseEntity<Boss> getBossById(@PathVariable Long id) {
        return ResponseEntity.ok(bossService.getBossById(id));
    }
    @DeleteMapping("")
    public ResponseEntity<String> deleteBossFromDatabase(@RequestParam("id") Long id){
        bossService.deleteBossFromDatabase(id);
        return ResponseEntity.ok("Boss with id: " + id + " deleted from the database.");

    }

}
