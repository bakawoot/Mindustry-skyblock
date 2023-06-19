package skyblock

import mindustry.mod.Mod
import skyblock.content.CreateLandBlock
import skyblock.content.CreateWaterBlock
import skyblock.content.CreateCoreZoneBlock
import skyblock.content.EnableShardCore

class Skyblock : Mod() {

    override fun loadContent() {
        CreateWaterBlock.load()
	CreateLandBlock.load()
	CreateCoreZoneBlock.load()
	EnableShardCore.load()
    }
}
