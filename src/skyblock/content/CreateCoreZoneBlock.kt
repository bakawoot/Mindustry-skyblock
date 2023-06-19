package skyblock.content

import mindustry.content.Items
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import skyblock.world.CreateCoreZone

class CreateCoreZoneBlock {
	companion object {
        lateinit var createCoreZone: Block

        fun load() {
            createCoreZone = CreateCoreZone("createCoreZone").apply {
                requirements(Category.effect, ItemStack.with(Items.copper, 24, Items.metaglass, 27, Items.titanium, 12, Items.thorium, 11, Items.silicon, 9))
                alwaysUnlocked = true
		size = 3
		buildCostMultiplier = 3.31f
            }
        }
    }
}
