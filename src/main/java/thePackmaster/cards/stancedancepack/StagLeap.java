package thePackmaster.cards.stancedancepack;


import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;

import thePackmaster.stances.sentinelpack.Angry;
import thePackmaster.stances.serpentinepack.CunningStance;
import thePackmaster.util.Wiz;
import thePackmaster.vfx.stancedancepack.StanceDanceEffect;

import static thePackmaster.SpireAnniversary5Mod.makeID;


public class StagLeap extends AbstractStanceDanceCard {
    public final static String ID = makeID("StagLeap");

    public StagLeap() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL);
        baseMagicNumber = magicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new VFXAction(p, new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GOLD_COLOR, ShockWaveEffect.ShockWaveType.NORMAL), 0.3F));

        this.addToBot(new ChangeStanceAction(new CunningStance()));
        AbstractDungeon.player.useJumpAnimation();
        Wiz.atb(new VFXAction(new StanceDanceEffect(p, false, true, false), 0.5F));
    }


    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }

}


