package skyblock.world

import mindustry.Vars.renderer
import mindustry.Vars
import mindustry.gen.Call
import mindustry.content.Blocks
import mindustry.game.Team
import mindustry.gen.Building
import mindustry.world.Block
import mindustry.world.Tile
import mindustry.world.blocks.environment.Floor
import arc.util.noise.*

open class CreateLand(name: String) : Block(name) {

    init {
        breakable = true
        floating = true
        update = true
    }

    override fun canPlaceOn(tile: Tile?, team: Team?, rotation: Int): Boolean {
        return tile != null && tile.floor().liquidDrop != null
    }

    inner class CreateLandBuild : Building() {
        override fun updateTile() {

            // Base of floor
            Noise.setSeed(50)
            val tileNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 40f, 50f)
            
            if (tileNoise <= -11)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.ice as Floor)
            if (tileNoise >= -11 && tileNoise < -9)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.snow as Floor)
            if (tileNoise >= -9 && tileNoise < -6)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.moss as Floor)
            if (tileNoise >= -6 && tileNoise < -3)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.grass as Floor)
            if (tileNoise >= -3 && tileNoise < 0)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.sand as Floor)
            if (tileNoise >= 0 && tileNoise < 3)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.darksand as Floor)
            if (tileNoise >= 3 && tileNoise < 6)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.stone as Floor)
            if (tileNoise >= 6 && tileNoise < 9)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.carbonStone as Floor)
            if (tileNoise >= 9)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.basalt as Floor)

            // Copper ore
            Noise.setSeed(301)
            val copperOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (copperOreNoise >= 42)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreCopper as Floor)

            // Coal ore
            Noise.setSeed(302)
            val coalOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (coalOreNoise >= 35)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreCoal as Floor)

            // Lead ore
            Noise.setSeed(303)
            val leadOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (leadOreNoise >= 35)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreLead as Floor)

            // Scrap ore
            Noise.setSeed(304)
            val scrapOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (scrapOreNoise >= 35)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreScrap as Floor)

            // Titanium ore
            Noise.setSeed(305)
            val titaniumOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (titaniumOreNoise >= 40)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreTitanium as Floor)

            // Thorium ore
            Noise.setSeed(306)
            val thoriumOreNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 13f, 200f)
            if (thoriumOreNoise >= 35)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setOverlay(Blocks.oreThorium as Floor)

            // Details & oil & cyro
            Noise.setSeed(100)
            val detailNoise: Float = Noise.noise(tile.x.toFloat(), tile.y.toFloat(), 20f, 100f)

            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.ice && detailNoise >= 10)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.cryofluid as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.snow && detailNoise >= 7)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.iceSnow as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.moss && detailNoise >= 7)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.sporeMoss as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.darksand && detailNoise >= 19)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.tar as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.stone && detailNoise >= 7)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.craters as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.basalt && detailNoise >= 7)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.hotrock as Floor)
            if (Vars.world.tile(tile.x.toInt(),tile.y.toInt()).floor() == Blocks.basalt && detailNoise >= 7.5f)
                Vars.world.tile(tile.x.toInt(),tile.y.toInt()).setFloor(Blocks.magmarock as Floor)
            
            tile.setAir()
            renderer.blocks.floor.recacheTile(tile)
        }
    }
}
