package skyblock.world

import mindustry.Vars
import mindustry.Vars.renderer
import mindustry.content.Blocks
import mindustry.game.Team
import mindustry.gen.Building
import mindustry.world.Block
import mindustry.world.Tile
import mindustry.world.blocks.environment.Floor

open class CreateCoreZone(name: String) : Block(name) {

    init {
        breakable = true
        floating = true
        update = true
    }

    override fun canPlaceOn(tile: Tile?, team: Team?, rotation: Int): Boolean {
        return tile != null && tile.floor().liquidDrop != null
    }

    inner class CreateCoreZoneBuild : Building() {
        override fun updateTile() {
			
		Vars.world.tile(tile.x.toInt() - 1, tile.y.toInt()).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt(), tile.y.toInt() - 1).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt() - 1, tile.y.toInt() - 1).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt() + 1, tile.y.toInt()).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt(), tile.y.toInt() + 1).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt() + 1, tile.y.toInt() + 1).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt() - 1, tile.y.toInt() + 1).setFloor(Blocks.coreZone as Floor)
		Vars.world.tile(tile.x.toInt() + 1, tile.y.toInt() - 1).setFloor(Blocks.coreZone as Floor)
		tile.setFloor(Blocks.coreZone as Floor)
		tile.setAir()
		renderer.blocks.floor.recacheTile(tile)
        }
    }
}
