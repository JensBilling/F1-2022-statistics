package se.iths.f12022statistics.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.f12022statistics.entity.Boss;
import se.iths.f12022statistics.service.BossService;

@RestController
@RequestMapping("api/bosses")
public class BossController {

    private final BossService bossService;

    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Boss>> getAllBosses(){
        return ResponseEntity.ok(bossService.getAllBosses());
    }

}
