package factoriesTest;

import static org.junit.Assert.*;

import java.io.IOException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Door;
import model.Enemy;
import model.Ground;
import model.ImageLoader;
import model.Key;
import model.Loot;
import model.Player;
import model.Spell;
import model.SpriteSet;
import model.WallTypeEnum;
import model.factories.UnitFactory;
import modelinterfaces.IUnit;

public class UnitFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateDoor_closed() throws IOException {
		Door door = UnitFactory.createDoorClosed(new SpriteSet(ImageLoader.getImageByPath("/sprites/gate_closed.png")));
		assertNotNull(door);
	}

	@Test
	public void testCreateDoor_open() throws IOException {
		Door door = UnitFactory.createDoorOpen(new SpriteSet(ImageLoader.getImageByPath("/sprites/gate_open.png")));
		assertNotNull(door);
	}

	@Test
	public void testCreateEnemy_Arrbarr() throws IOException {
		Enemy enemy = UnitFactory.createEnemyArrbarr(new SpriteSet(ImageLoader.getImageByPath("/sprites/monster_1.png")));
		assertNotNull(enemy);
	}

	@Test
	public void testCreateEnemy_Cargyv() throws IOException {
		Enemy enemy = UnitFactory.createEnemyCargyv(new SpriteSet(ImageLoader.getImageByPath("/sprites/monster_2.png")));
		assertNotNull(enemy);
	}

	@Test
	public void testCreateEnemy_Kyracj() throws IOException {
		Enemy enemy = UnitFactory.createEnemyKyracj(new SpriteSet(ImageLoader.getImageByPath("/sprites/monster_3.png")));
		assertNotNull(enemy);
	}

	@Test
	public void testCreateEnemy_Maarcg() throws IOException {
		Enemy enemy = UnitFactory.createEnemyMaarcg(new SpriteSet(ImageLoader.getImageByPath("/sprites/monster_4.png")));
		assertNotNull(enemy);
	}

	@Test
	public void testCreateGround_default() throws IOException {
		Ground ground = UnitFactory.createGroundDefault(new SpriteSet(ImageLoader.getImageByPath("/sprites/gate_closed.png")));
		assertNotNull(ground);
	}

	@Test
	public void testCreateKey_blue() throws IOException {
		Key key = UnitFactory.createKeyBlue(new SpriteSet(ImageLoader.getImageByPath("/sprites/crystal_ball0.png")));
		assertNotNull(key);
	}

	@Test
	public void testCreateLoot_coin() throws IOException {
		Loot loot = UnitFactory.createLootPurse(new SpriteSet(ImageLoader.getImageByPath("../sprites/purse.png")));
		assertNotNull(loot);
	}

	@Test
	public void testCreatePlayer_Lorann() throws IOException {
		Player player = UnitFactory.createPlayerLorann(new SpriteSet(ImageLoader.getImageByPath("/sprites/lorann_b.png")));
		assertNotNull(player);
	}

	@Test
	public void testCreateSpell() {
		Spell spell = UnitFactory.createSpell();
		assertNotNull(spell);
	}

	@Test
	public void testCreateWall() {
		IUnit wall = UnitFactory.createWall(WallTypeEnum.WALL_ROUND, "/sprites/bone.png");
		IUnit wall_h = UnitFactory.createWall(WallTypeEnum.WALL_HORIZONTAL, "/sprites/horizontal_bone.png");
		IUnit wall_v = UnitFactory.createWall(WallTypeEnum.WALL_VERTICAL, "/sprites/vertical_bone.png");
		assertNotNull(wall);
		assertNotNull(wall_h);
		assertNotNull(wall_v);
	}
}
