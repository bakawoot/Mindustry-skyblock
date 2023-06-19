package seadustry.world

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
            
            tile.setAir()
            renderer.blocks.floor.recacheTile(tile)
        }
    }
}
