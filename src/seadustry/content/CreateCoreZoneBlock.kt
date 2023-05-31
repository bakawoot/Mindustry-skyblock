package seadustry.content

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import seadustry.world.CreateCoreZone

class CreateCoreZoneBlock {
	companion object {
        lateinit var createCoreZone: Block

        fun load() {
            createCoreZone = CreateCoreZone("createCoreZone").apply {
                requirements(Category.effect, ItemStack.with(Items.sand, 0))
                alwaysUnlocked = true
            }
        }
    }
}