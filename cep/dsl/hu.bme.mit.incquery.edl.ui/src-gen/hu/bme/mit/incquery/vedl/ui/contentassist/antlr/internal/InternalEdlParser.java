package hu.bme.mit.incquery.vedl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.incquery.vedl.services.EdlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEdlParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'<'", "'=<'", "'=='", "'!='", "'>='", "'>'", "'contains'", "'startsWith'", "'endsWith'", "'FOUND'", "'LOST'", "'Chronicle'", "'Recent'", "'Unrestricted'", "'package'", "'.'", "'.*'", "'uses-incquery-patterns'", "'uses-eventsources'", "'EventModel'", "'{'", "'}'", "'AtomicEvent'", "'()'", "'id'", "':'", "'source'", "'parameterFilters'", "'IQPatternEvent'", "'IQPatternRef'", "'ChangeType'", "'ComplexEvent'", "'('", "')'", "'@Context'", "'@SamplingTime'", "'@Priority'", "'in'", "','", "']'", "'['", "'->'", "'-['", "']->'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalEdlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEdlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEdlParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g"; }


     
     	private EdlGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EdlGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRulePackageDeclaration"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:60:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:61:1: ( rulePackageDeclaration EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:62:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration61);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDeclaration68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:69:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:73:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:74:1: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:74:1: ( ( rule__PackageDeclaration__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:75:1: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:76:1: ( rule__PackageDeclaration__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:76:2: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration94);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleDOUBLE"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:88:1: entryRuleDOUBLE : ruleDOUBLE EOF ;
    public final void entryRuleDOUBLE() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:89:1: ( ruleDOUBLE EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:90:1: ruleDOUBLE EOF
            {
             before(grammarAccess.getDOUBLERule()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE121);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getDOUBLERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOUBLE128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDOUBLE"


    // $ANTLR start "ruleDOUBLE"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:97:1: ruleDOUBLE : ( ( rule__DOUBLE__Group__0 ) ) ;
    public final void ruleDOUBLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:101:2: ( ( ( rule__DOUBLE__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:102:1: ( ( rule__DOUBLE__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:102:1: ( ( rule__DOUBLE__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:103:1: ( rule__DOUBLE__Group__0 )
            {
             before(grammarAccess.getDOUBLEAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:104:1: ( rule__DOUBLE__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:104:2: rule__DOUBLE__Group__0
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE154);
            rule__DOUBLE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDOUBLEAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDOUBLE"


    // $ANTLR start "entryRuleQualifiedName"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:116:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:117:1: ( ruleQualifiedName EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:118:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:125:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:129:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:130:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:131:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:132:1: ( rule__QualifiedName__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:132:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:144:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:145:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:146:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard241);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:153:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:157:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:158:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:158:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:159:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:160:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:160:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard274);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:172:1: entryRuleUsage : ruleUsage EOF ;
    public final void entryRuleUsage() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:173:1: ( ruleUsage EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:174:1: ruleUsage EOF
            {
             before(grammarAccess.getUsageRule()); 
            pushFollow(FOLLOW_ruleUsage_in_entryRuleUsage301);
            ruleUsage();

            state._fsp--;

             after(grammarAccess.getUsageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUsage308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUsage"


    // $ANTLR start "ruleUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:181:1: ruleUsage : ( ( rule__Usage__Alternatives ) ) ;
    public final void ruleUsage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:185:2: ( ( ( rule__Usage__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:186:1: ( ( rule__Usage__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:186:1: ( ( rule__Usage__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:187:1: ( rule__Usage__Alternatives )
            {
             before(grammarAccess.getUsageAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:188:1: ( rule__Usage__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:188:2: rule__Usage__Alternatives
            {
            pushFollow(FOLLOW_rule__Usage__Alternatives_in_ruleUsage334);
            rule__Usage__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUsageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUsage"


    // $ANTLR start "entryRuleIQUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:200:1: entryRuleIQUsage : ruleIQUsage EOF ;
    public final void entryRuleIQUsage() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:201:1: ( ruleIQUsage EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:202:1: ruleIQUsage EOF
            {
             before(grammarAccess.getIQUsageRule()); 
            pushFollow(FOLLOW_ruleIQUsage_in_entryRuleIQUsage361);
            ruleIQUsage();

            state._fsp--;

             after(grammarAccess.getIQUsageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQUsage368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIQUsage"


    // $ANTLR start "ruleIQUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:209:1: ruleIQUsage : ( ( rule__IQUsage__Group__0 ) ) ;
    public final void ruleIQUsage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:213:2: ( ( ( rule__IQUsage__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:214:1: ( ( rule__IQUsage__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:214:1: ( ( rule__IQUsage__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:215:1: ( rule__IQUsage__Group__0 )
            {
             before(grammarAccess.getIQUsageAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:216:1: ( rule__IQUsage__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:216:2: rule__IQUsage__Group__0
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__0_in_ruleIQUsage394);
            rule__IQUsage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIQUsageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIQUsage"


    // $ANTLR start "entryRuleEventSourceUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:228:1: entryRuleEventSourceUsage : ruleEventSourceUsage EOF ;
    public final void entryRuleEventSourceUsage() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:229:1: ( ruleEventSourceUsage EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:230:1: ruleEventSourceUsage EOF
            {
             before(grammarAccess.getEventSourceUsageRule()); 
            pushFollow(FOLLOW_ruleEventSourceUsage_in_entryRuleEventSourceUsage421);
            ruleEventSourceUsage();

            state._fsp--;

             after(grammarAccess.getEventSourceUsageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventSourceUsage428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventSourceUsage"


    // $ANTLR start "ruleEventSourceUsage"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:237:1: ruleEventSourceUsage : ( ( rule__EventSourceUsage__Group__0 ) ) ;
    public final void ruleEventSourceUsage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:241:2: ( ( ( rule__EventSourceUsage__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:242:1: ( ( rule__EventSourceUsage__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:242:1: ( ( rule__EventSourceUsage__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:243:1: ( rule__EventSourceUsage__Group__0 )
            {
             before(grammarAccess.getEventSourceUsageAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:244:1: ( rule__EventSourceUsage__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:244:2: rule__EventSourceUsage__Group__0
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__0_in_ruleEventSourceUsage454);
            rule__EventSourceUsage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventSourceUsageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventSourceUsage"


    // $ANTLR start "entryRuleModel"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:256:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:260:1: ( ruleModel EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:261:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel486);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel493); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:271:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:276:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:277:1: ( ( rule__Model__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:277:1: ( ( rule__Model__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:278:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:279:1: ( rule__Model__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:279:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel523);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:292:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:293:1: ( ruleEvent EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:294:1: ruleEvent EOF
            {
             before(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent550);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent557); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:301:1: ruleEvent : ( ( rule__Event__Alternatives ) ) ;
    public final void ruleEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:305:2: ( ( ( rule__Event__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:306:1: ( ( rule__Event__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:306:1: ( ( rule__Event__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:307:1: ( rule__Event__Alternatives )
            {
             before(grammarAccess.getEventAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:308:1: ( rule__Event__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:308:2: rule__Event__Alternatives
            {
            pushFollow(FOLLOW_rule__Event__Alternatives_in_ruleEvent583);
            rule__Event__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleAbstractAtomicEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:320:1: entryRuleAbstractAtomicEvent : ruleAbstractAtomicEvent EOF ;
    public final void entryRuleAbstractAtomicEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:321:1: ( ruleAbstractAtomicEvent EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:322:1: ruleAbstractAtomicEvent EOF
            {
             before(grammarAccess.getAbstractAtomicEventRule()); 
            pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_entryRuleAbstractAtomicEvent610);
            ruleAbstractAtomicEvent();

            state._fsp--;

             after(grammarAccess.getAbstractAtomicEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractAtomicEvent617); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractAtomicEvent"


    // $ANTLR start "ruleAbstractAtomicEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:329:1: ruleAbstractAtomicEvent : ( ( rule__AbstractAtomicEvent__Alternatives ) ) ;
    public final void ruleAbstractAtomicEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:333:2: ( ( ( rule__AbstractAtomicEvent__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:334:1: ( ( rule__AbstractAtomicEvent__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:334:1: ( ( rule__AbstractAtomicEvent__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:335:1: ( rule__AbstractAtomicEvent__Alternatives )
            {
             before(grammarAccess.getAbstractAtomicEventAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:336:1: ( rule__AbstractAtomicEvent__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:336:2: rule__AbstractAtomicEvent__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractAtomicEvent__Alternatives_in_ruleAbstractAtomicEvent643);
            rule__AbstractAtomicEvent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractAtomicEventAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractAtomicEvent"


    // $ANTLR start "entryRuleAtomicEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:348:1: entryRuleAtomicEvent : ruleAtomicEvent EOF ;
    public final void entryRuleAtomicEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:349:1: ( ruleAtomicEvent EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:350:1: ruleAtomicEvent EOF
            {
             before(grammarAccess.getAtomicEventRule()); 
            pushFollow(FOLLOW_ruleAtomicEvent_in_entryRuleAtomicEvent670);
            ruleAtomicEvent();

            state._fsp--;

             after(grammarAccess.getAtomicEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtomicEvent677); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAtomicEvent"


    // $ANTLR start "ruleAtomicEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:357:1: ruleAtomicEvent : ( ( rule__AtomicEvent__Group__0 ) ) ;
    public final void ruleAtomicEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:361:2: ( ( ( rule__AtomicEvent__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:362:1: ( ( rule__AtomicEvent__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:362:1: ( ( rule__AtomicEvent__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:363:1: ( rule__AtomicEvent__Group__0 )
            {
             before(grammarAccess.getAtomicEventAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:364:1: ( rule__AtomicEvent__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:364:2: rule__AtomicEvent__Group__0
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__0_in_ruleAtomicEvent703);
            rule__AtomicEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAtomicEvent"


    // $ANTLR start "entryRuleIQPatternEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:376:1: entryRuleIQPatternEvent : ruleIQPatternEvent EOF ;
    public final void entryRuleIQPatternEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:377:1: ( ruleIQPatternEvent EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:378:1: ruleIQPatternEvent EOF
            {
             before(grammarAccess.getIQPatternEventRule()); 
            pushFollow(FOLLOW_ruleIQPatternEvent_in_entryRuleIQPatternEvent730);
            ruleIQPatternEvent();

            state._fsp--;

             after(grammarAccess.getIQPatternEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQPatternEvent737); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIQPatternEvent"


    // $ANTLR start "ruleIQPatternEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:385:1: ruleIQPatternEvent : ( ( rule__IQPatternEvent__Group__0 ) ) ;
    public final void ruleIQPatternEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:389:2: ( ( ( rule__IQPatternEvent__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:390:1: ( ( rule__IQPatternEvent__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:390:1: ( ( rule__IQPatternEvent__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:391:1: ( rule__IQPatternEvent__Group__0 )
            {
             before(grammarAccess.getIQPatternEventAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:392:1: ( rule__IQPatternEvent__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:392:2: rule__IQPatternEvent__Group__0
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__0_in_ruleIQPatternEvent763);
            rule__IQPatternEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIQPatternEvent"


    // $ANTLR start "entryRuleComplexEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:404:1: entryRuleComplexEvent : ruleComplexEvent EOF ;
    public final void entryRuleComplexEvent() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:405:1: ( ruleComplexEvent EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:406:1: ruleComplexEvent EOF
            {
             before(grammarAccess.getComplexEventRule()); 
            pushFollow(FOLLOW_ruleComplexEvent_in_entryRuleComplexEvent790);
            ruleComplexEvent();

            state._fsp--;

             after(grammarAccess.getComplexEventRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexEvent797); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComplexEvent"


    // $ANTLR start "ruleComplexEvent"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:413:1: ruleComplexEvent : ( ( rule__ComplexEvent__Group__0 ) ) ;
    public final void ruleComplexEvent() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:417:2: ( ( ( rule__ComplexEvent__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:418:1: ( ( rule__ComplexEvent__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:418:1: ( ( rule__ComplexEvent__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:419:1: ( rule__ComplexEvent__Group__0 )
            {
             before(grammarAccess.getComplexEventAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:420:1: ( rule__ComplexEvent__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:420:2: rule__ComplexEvent__Group__0
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__0_in_ruleComplexEvent823);
            rule__ComplexEvent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComplexEventAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexEvent"


    // $ANTLR start "entryRuleCEParamlist"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:432:1: entryRuleCEParamlist : ruleCEParamlist EOF ;
    public final void entryRuleCEParamlist() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:433:1: ( ruleCEParamlist EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:434:1: ruleCEParamlist EOF
            {
             before(grammarAccess.getCEParamlistRule()); 
            pushFollow(FOLLOW_ruleCEParamlist_in_entryRuleCEParamlist850);
            ruleCEParamlist();

            state._fsp--;

             after(grammarAccess.getCEParamlistRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCEParamlist857); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCEParamlist"


    // $ANTLR start "ruleCEParamlist"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:441:1: ruleCEParamlist : ( ( rule__CEParamlist__Group__0 ) ) ;
    public final void ruleCEParamlist() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:445:2: ( ( ( rule__CEParamlist__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:446:1: ( ( rule__CEParamlist__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:446:1: ( ( rule__CEParamlist__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:447:1: ( rule__CEParamlist__Group__0 )
            {
             before(grammarAccess.getCEParamlistAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:448:1: ( rule__CEParamlist__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:448:2: rule__CEParamlist__Group__0
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__0_in_ruleCEParamlist883);
            rule__CEParamlist__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCEParamlistAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCEParamlist"


    // $ANTLR start "entryRuleEventParamWithType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:460:1: entryRuleEventParamWithType : ruleEventParamWithType EOF ;
    public final void entryRuleEventParamWithType() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:461:1: ( ruleEventParamWithType EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:462:1: ruleEventParamWithType EOF
            {
             before(grammarAccess.getEventParamWithTypeRule()); 
            pushFollow(FOLLOW_ruleEventParamWithType_in_entryRuleEventParamWithType910);
            ruleEventParamWithType();

            state._fsp--;

             after(grammarAccess.getEventParamWithTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventParamWithType917); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventParamWithType"


    // $ANTLR start "ruleEventParamWithType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:469:1: ruleEventParamWithType : ( ( rule__EventParamWithType__Group__0 ) ) ;
    public final void ruleEventParamWithType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:473:2: ( ( ( rule__EventParamWithType__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:474:1: ( ( rule__EventParamWithType__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:474:1: ( ( rule__EventParamWithType__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:475:1: ( rule__EventParamWithType__Group__0 )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:476:1: ( rule__EventParamWithType__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:476:2: rule__EventParamWithType__Group__0
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__0_in_ruleEventParamWithType943);
            rule__EventParamWithType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventParamWithTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventParamWithType"


    // $ANTLR start "entryRuleParameterFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:488:1: entryRuleParameterFilter : ruleParameterFilter EOF ;
    public final void entryRuleParameterFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:489:1: ( ruleParameterFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:490:1: ruleParameterFilter EOF
            {
             before(grammarAccess.getParameterFilterRule()); 
            pushFollow(FOLLOW_ruleParameterFilter_in_entryRuleParameterFilter970);
            ruleParameterFilter();

            state._fsp--;

             after(grammarAccess.getParameterFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterFilter977); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterFilter"


    // $ANTLR start "ruleParameterFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:497:1: ruleParameterFilter : ( ( rule__ParameterFilter__Group__0 ) ) ;
    public final void ruleParameterFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:501:2: ( ( ( rule__ParameterFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:502:1: ( ( rule__ParameterFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:502:1: ( ( rule__ParameterFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:503:1: ( rule__ParameterFilter__Group__0 )
            {
             before(grammarAccess.getParameterFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:504:1: ( rule__ParameterFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:504:2: rule__ParameterFilter__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__0_in_ruleParameterFilter1003);
            rule__ParameterFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterFilter"


    // $ANTLR start "entryRuleAnnotations"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:516:1: entryRuleAnnotations : ruleAnnotations EOF ;
    public final void entryRuleAnnotations() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:517:1: ( ruleAnnotations EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:518:1: ruleAnnotations EOF
            {
             before(grammarAccess.getAnnotationsRule()); 
            pushFollow(FOLLOW_ruleAnnotations_in_entryRuleAnnotations1030);
            ruleAnnotations();

            state._fsp--;

             after(grammarAccess.getAnnotationsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotations1037); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAnnotations"


    // $ANTLR start "ruleAnnotations"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:525:1: ruleAnnotations : ( ( rule__Annotations__Alternatives ) ) ;
    public final void ruleAnnotations() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:529:2: ( ( ( rule__Annotations__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:530:1: ( ( rule__Annotations__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:530:1: ( ( rule__Annotations__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:531:1: ( rule__Annotations__Alternatives )
            {
             before(grammarAccess.getAnnotationsAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:532:1: ( rule__Annotations__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:532:2: rule__Annotations__Alternatives
            {
            pushFollow(FOLLOW_rule__Annotations__Alternatives_in_ruleAnnotations1063);
            rule__Annotations__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAnnotationsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnnotations"


    // $ANTLR start "entryRuleContextAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:544:1: entryRuleContextAnnotation : ruleContextAnnotation EOF ;
    public final void entryRuleContextAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:545:1: ( ruleContextAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:546:1: ruleContextAnnotation EOF
            {
             before(grammarAccess.getContextAnnotationRule()); 
            pushFollow(FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation1090);
            ruleContextAnnotation();

            state._fsp--;

             after(grammarAccess.getContextAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextAnnotation1097); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContextAnnotation"


    // $ANTLR start "ruleContextAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:553:1: ruleContextAnnotation : ( ( rule__ContextAnnotation__Group__0 ) ) ;
    public final void ruleContextAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:557:2: ( ( ( rule__ContextAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:558:1: ( ( rule__ContextAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:558:1: ( ( rule__ContextAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:559:1: ( rule__ContextAnnotation__Group__0 )
            {
             before(grammarAccess.getContextAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:560:1: ( rule__ContextAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:560:2: rule__ContextAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__0_in_ruleContextAnnotation1123);
            rule__ContextAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextAnnotation"


    // $ANTLR start "entryRuleSamplingAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:572:1: entryRuleSamplingAnnotation : ruleSamplingAnnotation EOF ;
    public final void entryRuleSamplingAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:573:1: ( ruleSamplingAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:574:1: ruleSamplingAnnotation EOF
            {
             before(grammarAccess.getSamplingAnnotationRule()); 
            pushFollow(FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation1150);
            ruleSamplingAnnotation();

            state._fsp--;

             after(grammarAccess.getSamplingAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSamplingAnnotation1157); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSamplingAnnotation"


    // $ANTLR start "ruleSamplingAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:581:1: ruleSamplingAnnotation : ( ( rule__SamplingAnnotation__Group__0 ) ) ;
    public final void ruleSamplingAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:585:2: ( ( ( rule__SamplingAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:586:1: ( ( rule__SamplingAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:586:1: ( ( rule__SamplingAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:587:1: ( rule__SamplingAnnotation__Group__0 )
            {
             before(grammarAccess.getSamplingAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:588:1: ( rule__SamplingAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:588:2: rule__SamplingAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__0_in_ruleSamplingAnnotation1183);
            rule__SamplingAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSamplingAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSamplingAnnotation"


    // $ANTLR start "entryRulePriorityAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:600:1: entryRulePriorityAnnotation : rulePriorityAnnotation EOF ;
    public final void entryRulePriorityAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:601:1: ( rulePriorityAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:602:1: rulePriorityAnnotation EOF
            {
             before(grammarAccess.getPriorityAnnotationRule()); 
            pushFollow(FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation1210);
            rulePriorityAnnotation();

            state._fsp--;

             after(grammarAccess.getPriorityAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePriorityAnnotation1217); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePriorityAnnotation"


    // $ANTLR start "rulePriorityAnnotation"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:609:1: rulePriorityAnnotation : ( ( rule__PriorityAnnotation__Group__0 ) ) ;
    public final void rulePriorityAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:613:2: ( ( ( rule__PriorityAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:614:1: ( ( rule__PriorityAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:614:1: ( ( rule__PriorityAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:615:1: ( rule__PriorityAnnotation__Group__0 )
            {
             before(grammarAccess.getPriorityAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:616:1: ( rule__PriorityAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:616:2: rule__PriorityAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__0_in_rulePriorityAnnotation1243);
            rule__PriorityAnnotation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPriorityAnnotationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePriorityAnnotation"


    // $ANTLR start "entryRuleParameterFilterRule"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:628:1: entryRuleParameterFilterRule : ruleParameterFilterRule EOF ;
    public final void entryRuleParameterFilterRule() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:629:1: ( ruleParameterFilterRule EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:630:1: ruleParameterFilterRule EOF
            {
             before(grammarAccess.getParameterFilterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule1270);
            ruleParameterFilterRule();

            state._fsp--;

             after(grammarAccess.getParameterFilterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterFilterRule1277); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterFilterRule"


    // $ANTLR start "ruleParameterFilterRule"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:637:1: ruleParameterFilterRule : ( ( rule__ParameterFilterRule__Alternatives ) ) ;
    public final void ruleParameterFilterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:641:2: ( ( ( rule__ParameterFilterRule__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:642:1: ( ( rule__ParameterFilterRule__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:642:1: ( ( rule__ParameterFilterRule__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:643:1: ( rule__ParameterFilterRule__Alternatives )
            {
             before(grammarAccess.getParameterFilterRuleAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:644:1: ( rule__ParameterFilterRule__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:644:2: rule__ParameterFilterRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterFilterRule__Alternatives_in_ruleParameterFilterRule1303);
            rule__ParameterFilterRule__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParameterFilterRuleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterFilterRule"


    // $ANTLR start "entryRuleRangeFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:656:1: entryRuleRangeFilter : ruleRangeFilter EOF ;
    public final void entryRuleRangeFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:657:1: ( ruleRangeFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:658:1: ruleRangeFilter EOF
            {
             before(grammarAccess.getRangeFilterRule()); 
            pushFollow(FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter1330);
            ruleRangeFilter();

            state._fsp--;

             after(grammarAccess.getRangeFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeFilter1337); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRangeFilter"


    // $ANTLR start "ruleRangeFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:665:1: ruleRangeFilter : ( ( rule__RangeFilter__Group__0 ) ) ;
    public final void ruleRangeFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:669:2: ( ( ( rule__RangeFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:670:1: ( ( rule__RangeFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:670:1: ( ( rule__RangeFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:671:1: ( rule__RangeFilter__Group__0 )
            {
             before(grammarAccess.getRangeFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:672:1: ( rule__RangeFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:672:2: rule__RangeFilter__Group__0
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__0_in_ruleRangeFilter1363);
            rule__RangeFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRangeFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRangeFilter"


    // $ANTLR start "entryRuleRange"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:684:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:685:1: ( ruleRange EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:686:1: ruleRange EOF
            {
             before(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange1390);
            ruleRange();

            state._fsp--;

             after(grammarAccess.getRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange1397); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:693:1: ruleRange : ( ( rule__Range__Alternatives ) ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:697:2: ( ( ( rule__Range__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:698:1: ( ( rule__Range__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:698:1: ( ( rule__Range__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:699:1: ( rule__Range__Alternatives )
            {
             before(grammarAccess.getRangeAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:700:1: ( rule__Range__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:700:2: rule__Range__Alternatives
            {
            pushFollow(FOLLOW_rule__Range__Alternatives_in_ruleRange1423);
            rule__Range__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRangeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleOpenOpen"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:712:1: entryRuleOpenOpen : ruleOpenOpen EOF ;
    public final void entryRuleOpenOpen() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:713:1: ( ruleOpenOpen EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:714:1: ruleOpenOpen EOF
            {
             before(grammarAccess.getOpenOpenRule()); 
            pushFollow(FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen1450);
            ruleOpenOpen();

            state._fsp--;

             after(grammarAccess.getOpenOpenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenOpen1457); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpenOpen"


    // $ANTLR start "ruleOpenOpen"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:721:1: ruleOpenOpen : ( ( rule__OpenOpen__Group__0 ) ) ;
    public final void ruleOpenOpen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:725:2: ( ( ( rule__OpenOpen__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:726:1: ( ( rule__OpenOpen__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:726:1: ( ( rule__OpenOpen__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:727:1: ( rule__OpenOpen__Group__0 )
            {
             before(grammarAccess.getOpenOpenAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:728:1: ( rule__OpenOpen__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:728:2: rule__OpenOpen__Group__0
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__0_in_ruleOpenOpen1483);
            rule__OpenOpen__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOpenOpenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpenOpen"


    // $ANTLR start "entryRuleOpenClosed"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:740:1: entryRuleOpenClosed : ruleOpenClosed EOF ;
    public final void entryRuleOpenClosed() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:741:1: ( ruleOpenClosed EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:742:1: ruleOpenClosed EOF
            {
             before(grammarAccess.getOpenClosedRule()); 
            pushFollow(FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed1510);
            ruleOpenClosed();

            state._fsp--;

             after(grammarAccess.getOpenClosedRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenClosed1517); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOpenClosed"


    // $ANTLR start "ruleOpenClosed"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:749:1: ruleOpenClosed : ( ( rule__OpenClosed__Group__0 ) ) ;
    public final void ruleOpenClosed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:753:2: ( ( ( rule__OpenClosed__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:754:1: ( ( rule__OpenClosed__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:754:1: ( ( rule__OpenClosed__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:755:1: ( rule__OpenClosed__Group__0 )
            {
             before(grammarAccess.getOpenClosedAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:756:1: ( rule__OpenClosed__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:756:2: rule__OpenClosed__Group__0
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__0_in_ruleOpenClosed1543);
            rule__OpenClosed__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOpenClosedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOpenClosed"


    // $ANTLR start "entryRuleClosedClosed"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:768:1: entryRuleClosedClosed : ruleClosedClosed EOF ;
    public final void entryRuleClosedClosed() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:769:1: ( ruleClosedClosed EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:770:1: ruleClosedClosed EOF
            {
             before(grammarAccess.getClosedClosedRule()); 
            pushFollow(FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed1570);
            ruleClosedClosed();

            state._fsp--;

             after(grammarAccess.getClosedClosedRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedClosed1577); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClosedClosed"


    // $ANTLR start "ruleClosedClosed"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:777:1: ruleClosedClosed : ( ( rule__ClosedClosed__Group__0 ) ) ;
    public final void ruleClosedClosed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:781:2: ( ( ( rule__ClosedClosed__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:782:1: ( ( rule__ClosedClosed__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:782:1: ( ( rule__ClosedClosed__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:783:1: ( rule__ClosedClosed__Group__0 )
            {
             before(grammarAccess.getClosedClosedAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:784:1: ( rule__ClosedClosed__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:784:2: rule__ClosedClosed__Group__0
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__0_in_ruleClosedClosed1603);
            rule__ClosedClosed__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClosedClosedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClosedClosed"


    // $ANTLR start "entryRuleClosedOpen"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:796:1: entryRuleClosedOpen : ruleClosedOpen EOF ;
    public final void entryRuleClosedOpen() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:797:1: ( ruleClosedOpen EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:798:1: ruleClosedOpen EOF
            {
             before(grammarAccess.getClosedOpenRule()); 
            pushFollow(FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen1630);
            ruleClosedOpen();

            state._fsp--;

             after(grammarAccess.getClosedOpenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedOpen1637); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClosedOpen"


    // $ANTLR start "ruleClosedOpen"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:805:1: ruleClosedOpen : ( ( rule__ClosedOpen__Group__0 ) ) ;
    public final void ruleClosedOpen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:809:2: ( ( ( rule__ClosedOpen__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:810:1: ( ( rule__ClosedOpen__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:810:1: ( ( rule__ClosedOpen__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:811:1: ( rule__ClosedOpen__Group__0 )
            {
             before(grammarAccess.getClosedOpenAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:812:1: ( rule__ClosedOpen__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:812:2: rule__ClosedOpen__Group__0
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__0_in_ruleClosedOpen1663);
            rule__ClosedOpen__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClosedOpenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClosedOpen"


    // $ANTLR start "entryRuleNumericFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:824:1: entryRuleNumericFilter : ruleNumericFilter EOF ;
    public final void entryRuleNumericFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:825:1: ( ruleNumericFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:826:1: ruleNumericFilter EOF
            {
             before(grammarAccess.getNumericFilterRule()); 
            pushFollow(FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter1690);
            ruleNumericFilter();

            state._fsp--;

             after(grammarAccess.getNumericFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericFilter1697); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumericFilter"


    // $ANTLR start "ruleNumericFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:833:1: ruleNumericFilter : ( ( rule__NumericFilter__Group__0 ) ) ;
    public final void ruleNumericFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:837:2: ( ( ( rule__NumericFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:838:1: ( ( rule__NumericFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:838:1: ( ( rule__NumericFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:839:1: ( rule__NumericFilter__Group__0 )
            {
             before(grammarAccess.getNumericFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:840:1: ( rule__NumericFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:840:2: rule__NumericFilter__Group__0
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__0_in_ruleNumericFilter1723);
            rule__NumericFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumericFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumericFilter"


    // $ANTLR start "entryRuleNumericOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:852:1: entryRuleNumericOperator : ruleNumericOperator EOF ;
    public final void entryRuleNumericOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:853:1: ( ruleNumericOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:854:1: ruleNumericOperator EOF
            {
             before(grammarAccess.getNumericOperatorRule()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator1750);
            ruleNumericOperator();

            state._fsp--;

             after(grammarAccess.getNumericOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericOperator1757); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumericOperator"


    // $ANTLR start "ruleNumericOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:861:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:865:2: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:866:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:866:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:867:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:868:1: ( rule__NumericOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:868:2: rule__NumericOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1783);
            rule__NumericOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumericOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumericOperator"


    // $ANTLR start "entryRuleLiteralFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:880:1: entryRuleLiteralFilter : ruleLiteralFilter EOF ;
    public final void entryRuleLiteralFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:881:1: ( ruleLiteralFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:882:1: ruleLiteralFilter EOF
            {
             before(grammarAccess.getLiteralFilterRule()); 
            pushFollow(FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter1810);
            ruleLiteralFilter();

            state._fsp--;

             after(grammarAccess.getLiteralFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFilter1817); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralFilter"


    // $ANTLR start "ruleLiteralFilter"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:889:1: ruleLiteralFilter : ( ( rule__LiteralFilter__Group__0 ) ) ;
    public final void ruleLiteralFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:893:2: ( ( ( rule__LiteralFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:894:1: ( ( rule__LiteralFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:894:1: ( ( rule__LiteralFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:895:1: ( rule__LiteralFilter__Group__0 )
            {
             before(grammarAccess.getLiteralFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:896:1: ( rule__LiteralFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:896:2: rule__LiteralFilter__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__0_in_ruleLiteralFilter1843);
            rule__LiteralFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLiteralFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralFilter"


    // $ANTLR start "entryRuleLiteralOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:908:1: entryRuleLiteralOperator : ruleLiteralOperator EOF ;
    public final void entryRuleLiteralOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:909:1: ( ruleLiteralOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:910:1: ruleLiteralOperator EOF
            {
             before(grammarAccess.getLiteralOperatorRule()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator1870);
            ruleLiteralOperator();

            state._fsp--;

             after(grammarAccess.getLiteralOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralOperator1877); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralOperator"


    // $ANTLR start "ruleLiteralOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:917:1: ruleLiteralOperator : ( ( rule__LiteralOperator__Alternatives ) ) ;
    public final void ruleLiteralOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:921:2: ( ( ( rule__LiteralOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:922:1: ( ( rule__LiteralOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:922:1: ( ( rule__LiteralOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:923:1: ( rule__LiteralOperator__Alternatives )
            {
             before(grammarAccess.getLiteralOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:924:1: ( rule__LiteralOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:924:2: rule__LiteralOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralOperator__Alternatives_in_ruleLiteralOperator1903);
            rule__LiteralOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralOperator"


    // $ANTLR start "entryRuleNegationOpartor"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:936:1: entryRuleNegationOpartor : ruleNegationOpartor EOF ;
    public final void entryRuleNegationOpartor() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:937:1: ( ruleNegationOpartor EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:938:1: ruleNegationOpartor EOF
            {
             before(grammarAccess.getNegationOpartorRule()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor1930);
            ruleNegationOpartor();

            state._fsp--;

             after(grammarAccess.getNegationOpartorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegationOpartor1937); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNegationOpartor"


    // $ANTLR start "ruleNegationOpartor"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:945:1: ruleNegationOpartor : ( 'not' ) ;
    public final void ruleNegationOpartor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:949:2: ( ( 'not' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:950:1: ( 'not' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:950:1: ( 'not' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:951:1: 'not'
            {
             before(grammarAccess.getNegationOpartorAccess().getNotKeyword()); 
            match(input,11,FOLLOW_11_in_ruleNegationOpartor1964); 
             after(grammarAccess.getNegationOpartorAccess().getNotKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegationOpartor"


    // $ANTLR start "entryRuleComplexEventExpression"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:966:1: entryRuleComplexEventExpression : ruleComplexEventExpression EOF ;
    public final void entryRuleComplexEventExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:967:1: ( ruleComplexEventExpression EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:968:1: ruleComplexEventExpression EOF
            {
             before(grammarAccess.getComplexEventExpressionRule()); 
            pushFollow(FOLLOW_ruleComplexEventExpression_in_entryRuleComplexEventExpression1992);
            ruleComplexEventExpression();

            state._fsp--;

             after(grammarAccess.getComplexEventExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexEventExpression1999); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComplexEventExpression"


    // $ANTLR start "ruleComplexEventExpression"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:975:1: ruleComplexEventExpression : ( ruleFollowsExpression ) ;
    public final void ruleComplexEventExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:979:2: ( ( ruleFollowsExpression ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:980:1: ( ruleFollowsExpression )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:980:1: ( ruleFollowsExpression )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:981:1: ruleFollowsExpression
            {
             before(grammarAccess.getComplexEventExpressionAccess().getFollowsExpressionParserRuleCall()); 
            pushFollow(FOLLOW_ruleFollowsExpression_in_ruleComplexEventExpression2025);
            ruleFollowsExpression();

            state._fsp--;

             after(grammarAccess.getComplexEventExpressionAccess().getFollowsExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexEventExpression"


    // $ANTLR start "entryRuleFollowsExpression"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:994:1: entryRuleFollowsExpression : ruleFollowsExpression EOF ;
    public final void entryRuleFollowsExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:995:1: ( ruleFollowsExpression EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:996:1: ruleFollowsExpression EOF
            {
             before(grammarAccess.getFollowsExpressionRule()); 
            pushFollow(FOLLOW_ruleFollowsExpression_in_entryRuleFollowsExpression2051);
            ruleFollowsExpression();

            state._fsp--;

             after(grammarAccess.getFollowsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsExpression2058); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFollowsExpression"


    // $ANTLR start "ruleFollowsExpression"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1003:1: ruleFollowsExpression : ( ( rule__FollowsExpression__Group__0 ) ) ;
    public final void ruleFollowsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1007:2: ( ( ( rule__FollowsExpression__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1008:1: ( ( rule__FollowsExpression__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1008:1: ( ( rule__FollowsExpression__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1009:1: ( rule__FollowsExpression__Group__0 )
            {
             before(grammarAccess.getFollowsExpressionAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1010:1: ( rule__FollowsExpression__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1010:2: rule__FollowsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__0_in_ruleFollowsExpression2084);
            rule__FollowsExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFollowsExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFollowsExpression"


    // $ANTLR start "entryRuleEventWithFollowsOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1022:1: entryRuleEventWithFollowsOperator : ruleEventWithFollowsOperator EOF ;
    public final void entryRuleEventWithFollowsOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1023:1: ( ruleEventWithFollowsOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1024:1: ruleEventWithFollowsOperator EOF
            {
             before(grammarAccess.getEventWithFollowsOperatorRule()); 
            pushFollow(FOLLOW_ruleEventWithFollowsOperator_in_entryRuleEventWithFollowsOperator2111);
            ruleEventWithFollowsOperator();

            state._fsp--;

             after(grammarAccess.getEventWithFollowsOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventWithFollowsOperator2118); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventWithFollowsOperator"


    // $ANTLR start "ruleEventWithFollowsOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1031:1: ruleEventWithFollowsOperator : ( ( rule__EventWithFollowsOperator__Group__0 ) ) ;
    public final void ruleEventWithFollowsOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1035:2: ( ( ( rule__EventWithFollowsOperator__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1036:1: ( ( rule__EventWithFollowsOperator__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1036:1: ( ( rule__EventWithFollowsOperator__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1037:1: ( rule__EventWithFollowsOperator__Group__0 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1038:1: ( rule__EventWithFollowsOperator__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1038:2: rule__EventWithFollowsOperator__Group__0
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__0_in_ruleEventWithFollowsOperator2144);
            rule__EventWithFollowsOperator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventWithFollowsOperatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventWithFollowsOperator"


    // $ANTLR start "entryRuleFollowsOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1050:1: entryRuleFollowsOperator : ruleFollowsOperator EOF ;
    public final void entryRuleFollowsOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1051:1: ( ruleFollowsOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1052:1: ruleFollowsOperator EOF
            {
             before(grammarAccess.getFollowsOperatorRule()); 
            pushFollow(FOLLOW_ruleFollowsOperator_in_entryRuleFollowsOperator2171);
            ruleFollowsOperator();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperator2178); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFollowsOperator"


    // $ANTLR start "ruleFollowsOperator"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1059:1: ruleFollowsOperator : ( ( rule__FollowsOperator__Alternatives ) ) ;
    public final void ruleFollowsOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1063:2: ( ( ( rule__FollowsOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1064:1: ( ( rule__FollowsOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1064:1: ( ( rule__FollowsOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1065:1: ( rule__FollowsOperator__Alternatives )
            {
             before(grammarAccess.getFollowsOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1066:1: ( rule__FollowsOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1066:2: rule__FollowsOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__FollowsOperator__Alternatives_in_ruleFollowsOperator2204);
            rule__FollowsOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFollowsOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFollowsOperator"


    // $ANTLR start "entryRuleFollowsOperatorNoTW"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1078:1: entryRuleFollowsOperatorNoTW : ruleFollowsOperatorNoTW EOF ;
    public final void entryRuleFollowsOperatorNoTW() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1079:1: ( ruleFollowsOperatorNoTW EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1080:1: ruleFollowsOperatorNoTW EOF
            {
             before(grammarAccess.getFollowsOperatorNoTWRule()); 
            pushFollow(FOLLOW_ruleFollowsOperatorNoTW_in_entryRuleFollowsOperatorNoTW2231);
            ruleFollowsOperatorNoTW();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorNoTWRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperatorNoTW2238); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFollowsOperatorNoTW"


    // $ANTLR start "ruleFollowsOperatorNoTW"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1087:1: ruleFollowsOperatorNoTW : ( ( rule__FollowsOperatorNoTW__Group__0 ) ) ;
    public final void ruleFollowsOperatorNoTW() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1091:2: ( ( ( rule__FollowsOperatorNoTW__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1092:1: ( ( rule__FollowsOperatorNoTW__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1092:1: ( ( rule__FollowsOperatorNoTW__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1093:1: ( rule__FollowsOperatorNoTW__Group__0 )
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1094:1: ( rule__FollowsOperatorNoTW__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1094:2: rule__FollowsOperatorNoTW__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__0_in_ruleFollowsOperatorNoTW2264);
            rule__FollowsOperatorNoTW__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFollowsOperatorNoTWAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFollowsOperatorNoTW"


    // $ANTLR start "entryRuleFollowsOperatorViaTW"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1106:1: entryRuleFollowsOperatorViaTW : ruleFollowsOperatorViaTW EOF ;
    public final void entryRuleFollowsOperatorViaTW() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1107:1: ( ruleFollowsOperatorViaTW EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1108:1: ruleFollowsOperatorViaTW EOF
            {
             before(grammarAccess.getFollowsOperatorViaTWRule()); 
            pushFollow(FOLLOW_ruleFollowsOperatorViaTW_in_entryRuleFollowsOperatorViaTW2291);
            ruleFollowsOperatorViaTW();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorViaTWRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperatorViaTW2298); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFollowsOperatorViaTW"


    // $ANTLR start "ruleFollowsOperatorViaTW"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1115:1: ruleFollowsOperatorViaTW : ( ( rule__FollowsOperatorViaTW__Group__0 ) ) ;
    public final void ruleFollowsOperatorViaTW() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1119:2: ( ( ( rule__FollowsOperatorViaTW__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1120:1: ( ( rule__FollowsOperatorViaTW__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1120:1: ( ( rule__FollowsOperatorViaTW__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1121:1: ( rule__FollowsOperatorViaTW__Group__0 )
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1122:1: ( rule__FollowsOperatorViaTW__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1122:2: rule__FollowsOperatorViaTW__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__0_in_ruleFollowsOperatorViaTW2324);
            rule__FollowsOperatorViaTW__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFollowsOperatorViaTWAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFollowsOperatorViaTW"


    // $ANTLR start "entryRuleEventWithMultiplicity"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1134:1: entryRuleEventWithMultiplicity : ruleEventWithMultiplicity EOF ;
    public final void entryRuleEventWithMultiplicity() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1135:1: ( ruleEventWithMultiplicity EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1136:1: ruleEventWithMultiplicity EOF
            {
             before(grammarAccess.getEventWithMultiplicityRule()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_entryRuleEventWithMultiplicity2351);
            ruleEventWithMultiplicity();

            state._fsp--;

             after(grammarAccess.getEventWithMultiplicityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventWithMultiplicity2358); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEventWithMultiplicity"


    // $ANTLR start "ruleEventWithMultiplicity"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1143:1: ruleEventWithMultiplicity : ( ( rule__EventWithMultiplicity__Group__0 ) ) ;
    public final void ruleEventWithMultiplicity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1147:2: ( ( ( rule__EventWithMultiplicity__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1148:1: ( ( rule__EventWithMultiplicity__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1148:1: ( ( rule__EventWithMultiplicity__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1149:1: ( rule__EventWithMultiplicity__Group__0 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1150:1: ( rule__EventWithMultiplicity__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1150:2: rule__EventWithMultiplicity__Group__0
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__0_in_ruleEventWithMultiplicity2384);
            rule__EventWithMultiplicity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEventWithMultiplicityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEventWithMultiplicity"


    // $ANTLR start "ruleIQPatternChangeType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1163:1: ruleIQPatternChangeType : ( ( rule__IQPatternChangeType__Alternatives ) ) ;
    public final void ruleIQPatternChangeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1167:1: ( ( ( rule__IQPatternChangeType__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1168:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1168:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1169:1: ( rule__IQPatternChangeType__Alternatives )
            {
             before(grammarAccess.getIQPatternChangeTypeAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1170:1: ( rule__IQPatternChangeType__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1170:2: rule__IQPatternChangeType__Alternatives
            {
            pushFollow(FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2421);
            rule__IQPatternChangeType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternChangeTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIQPatternChangeType"


    // $ANTLR start "ruleContext"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1182:1: ruleContext : ( ( rule__Context__Alternatives ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1186:1: ( ( ( rule__Context__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1187:1: ( ( rule__Context__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1187:1: ( ( rule__Context__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1188:1: ( rule__Context__Alternatives )
            {
             before(grammarAccess.getContextAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1189:1: ( rule__Context__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1189:2: rule__Context__Alternatives
            {
            pushFollow(FOLLOW_rule__Context__Alternatives_in_ruleContext2457);
            rule__Context__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "rule__Usage__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1200:1: rule__Usage__Alternatives : ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) );
    public final void rule__Usage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1204:1: ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==29) ) {
                alt1=1;
            }
            else if ( (LA1_0==30) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1205:1: ( ruleIQUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1205:1: ( ruleIQUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1206:1: ruleIQUsage
                    {
                     before(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2492);
                    ruleIQUsage();

                    state._fsp--;

                     after(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1211:6: ( ruleEventSourceUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1211:6: ( ruleEventSourceUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1212:1: ruleEventSourceUsage
                    {
                     before(grammarAccess.getUsageAccess().getEventSourceUsageParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2509);
                    ruleEventSourceUsage();

                    state._fsp--;

                     after(grammarAccess.getUsageAccess().getEventSourceUsageParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Usage__Alternatives"


    // $ANTLR start "rule__Event__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1222:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );
    public final void rule__Event__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1226:1: ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1227:1: ( ruleAbstractAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1227:1: ( ruleAbstractAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1228:1: ruleAbstractAtomicEvent
                    {
                     before(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2541);
                    ruleAbstractAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:6: ( ruleComplexEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:6: ( ruleComplexEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1234:1: ruleComplexEvent
                    {
                     before(grammarAccess.getEventAccess().getComplexEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2558);
                    ruleComplexEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getComplexEventParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Event__Alternatives"


    // $ANTLR start "rule__AbstractAtomicEvent__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1244:1: rule__AbstractAtomicEvent__Alternatives : ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) );
    public final void rule__AbstractAtomicEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1248:1: ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==34||(LA3_0>=46 && LA3_0<=48)) ) {
                alt3=1;
            }
            else if ( (LA3_0==40) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1249:1: ( ruleAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1249:1: ( ruleAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1250:1: ruleAtomicEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2590);
                    ruleAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1255:6: ( ruleIQPatternEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1255:6: ( ruleIQPatternEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1256:1: ruleIQPatternEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getIQPatternEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2607);
                    ruleIQPatternEvent();

                    state._fsp--;

                     after(grammarAccess.getAbstractAtomicEventAccess().getIQPatternEventParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractAtomicEvent__Alternatives"


    // $ANTLR start "rule__Annotations__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1266:1: rule__Annotations__Alternatives : ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) );
    public final void rule__Annotations__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1270:1: ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt4=1;
                }
                break;
            case 47:
                {
                alt4=2;
                }
                break;
            case 48:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1271:1: ( ruleContextAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1271:1: ( ruleContextAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1272:1: ruleContextAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2639);
                    ruleContextAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1277:6: ( ruleSamplingAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1277:6: ( ruleSamplingAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1278:1: ruleSamplingAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2656);
                    ruleSamplingAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1283:6: ( rulePriorityAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1283:6: ( rulePriorityAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1284:1: rulePriorityAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getPriorityAnnotationParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2673);
                    rulePriorityAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getPriorityAnnotationParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Annotations__Alternatives"


    // $ANTLR start "rule__ParameterFilterRule__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1294:1: rule__ParameterFilterRule__Alternatives : ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) );
    public final void rule__ParameterFilterRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1298:1: ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==49) ) {
                    alt5=1;
                }
                else if ( ((LA5_1>=18 && LA5_1<=20)) ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                alt5=1;
                }
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
            case 19:
            case 20:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1299:1: ( ruleRangeFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1299:1: ( ruleRangeFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1300:1: ruleRangeFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2705);
                    ruleRangeFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1305:6: ( ruleNumericFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1305:6: ( ruleNumericFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1306:1: ruleNumericFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2722);
                    ruleNumericFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:6: ( ruleLiteralFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:6: ( ruleLiteralFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1312:1: ruleLiteralFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getLiteralFilterParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2739);
                    ruleLiteralFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getLiteralFilterParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilterRule__Alternatives"


    // $ANTLR start "rule__Range__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1322:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );
    public final void rule__Range__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1326:1: ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1327:1: ( ruleOpenOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1327:1: ( ruleOpenOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1328:1: ruleOpenOpen
                    {
                     before(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2771);
                    ruleOpenOpen();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1333:6: ( ruleOpenClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1333:6: ( ruleOpenClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1334:1: ruleOpenClosed
                    {
                     before(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2788);
                    ruleOpenClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1339:6: ( ruleClosedClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1339:6: ( ruleClosedClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1340:1: ruleClosedClosed
                    {
                     before(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2805);
                    ruleClosedClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1345:6: ( ruleClosedOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1345:6: ( ruleClosedOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1346:1: ruleClosedOpen
                    {
                     before(grammarAccess.getRangeAccess().getClosedOpenParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2822);
                    ruleClosedOpen();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getClosedOpenParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Range__Alternatives"


    // $ANTLR start "rule__NumericOperator__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1356:1: rule__NumericOperator__Alternatives : ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1360:1: ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt7=1;
                }
                break;
            case 13:
                {
                alt7=2;
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            case 15:
                {
                alt7=4;
                }
                break;
            case 16:
                {
                alt7=5;
                }
                break;
            case 17:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1361:1: ( '<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1361:1: ( '<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1362:1: '<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__NumericOperator__Alternatives2855); 
                     after(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1369:6: ( '=<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1369:6: ( '=<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1370:1: '=<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__NumericOperator__Alternatives2875); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1377:6: ( '==' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1377:6: ( '==' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1378:1: '=='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__NumericOperator__Alternatives2895); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1385:6: ( '!=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1385:6: ( '!=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1386:1: '!='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 
                    match(input,15,FOLLOW_15_in_rule__NumericOperator__Alternatives2915); 
                     after(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1393:6: ( '>=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1393:6: ( '>=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1394:1: '>='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 
                    match(input,16,FOLLOW_16_in_rule__NumericOperator__Alternatives2935); 
                     after(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1401:6: ( '>' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1401:6: ( '>' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1402:1: '>'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignKeyword_5()); 
                    match(input,17,FOLLOW_17_in_rule__NumericOperator__Alternatives2955); 
                     after(grammarAccess.getNumericOperatorAccess().getGreaterThanSignKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericOperator__Alternatives"


    // $ANTLR start "rule__LiteralOperator__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1414:1: rule__LiteralOperator__Alternatives : ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) );
    public final void rule__LiteralOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1418:1: ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt8=1;
                }
                break;
            case 19:
                {
                alt8=2;
                }
                break;
            case 20:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1419:1: ( 'contains' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1419:1: ( 'contains' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1420:1: 'contains'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__LiteralOperator__Alternatives2990); 
                     after(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1427:6: ( 'startsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1427:6: ( 'startsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1428:1: 'startsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__LiteralOperator__Alternatives3010); 
                     after(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1435:6: ( 'endsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1435:6: ( 'endsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1436:1: 'endsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getEndsWithKeyword_2()); 
                    match(input,20,FOLLOW_20_in_rule__LiteralOperator__Alternatives3030); 
                     after(grammarAccess.getLiteralOperatorAccess().getEndsWithKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralOperator__Alternatives"


    // $ANTLR start "rule__FollowsOperator__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1448:1: rule__FollowsOperator__Alternatives : ( ( ruleFollowsOperatorNoTW ) | ( ruleFollowsOperatorViaTW ) );
    public final void rule__FollowsOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1452:1: ( ( ruleFollowsOperatorNoTW ) | ( ruleFollowsOperatorViaTW ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==53) ) {
                alt9=1;
            }
            else if ( (LA9_0==54) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1453:1: ( ruleFollowsOperatorNoTW )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1453:1: ( ruleFollowsOperatorNoTW )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1454:1: ruleFollowsOperatorNoTW
                    {
                     before(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorNoTWParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFollowsOperatorNoTW_in_rule__FollowsOperator__Alternatives3064);
                    ruleFollowsOperatorNoTW();

                    state._fsp--;

                     after(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorNoTWParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1459:6: ( ruleFollowsOperatorViaTW )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1459:6: ( ruleFollowsOperatorViaTW )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1460:1: ruleFollowsOperatorViaTW
                    {
                     before(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorViaTWParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFollowsOperatorViaTW_in_rule__FollowsOperator__Alternatives3081);
                    ruleFollowsOperatorViaTW();

                    state._fsp--;

                     after(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorViaTWParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperator__Alternatives"


    // $ANTLR start "rule__IQPatternChangeType__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1470:1: rule__IQPatternChangeType__Alternatives : ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) );
    public final void rule__IQPatternChangeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1474:1: ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==22) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1475:1: ( ( 'FOUND' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1475:1: ( ( 'FOUND' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1476:1: ( 'FOUND' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1477:1: ( 'FOUND' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1477:3: 'FOUND'
                    {
                    match(input,21,FOLLOW_21_in_rule__IQPatternChangeType__Alternatives3114); 

                    }

                     after(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1482:6: ( ( 'LOST' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1482:6: ( ( 'LOST' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1483:1: ( 'LOST' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1484:1: ( 'LOST' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1484:3: 'LOST'
                    {
                    match(input,22,FOLLOW_22_in_rule__IQPatternChangeType__Alternatives3135); 

                    }

                     after(grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternChangeType__Alternatives"


    // $ANTLR start "rule__Context__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1494:1: rule__Context__Alternatives : ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) );
    public final void rule__Context__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1498:1: ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt11=1;
                }
                break;
            case 24:
                {
                alt11=2;
                }
                break;
            case 25:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1499:1: ( ( 'Chronicle' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1499:1: ( ( 'Chronicle' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1500:1: ( 'Chronicle' )
                    {
                     before(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1501:1: ( 'Chronicle' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1501:3: 'Chronicle'
                    {
                    match(input,23,FOLLOW_23_in_rule__Context__Alternatives3171); 

                    }

                     after(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1506:6: ( ( 'Recent' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1506:6: ( ( 'Recent' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1507:1: ( 'Recent' )
                    {
                     before(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1508:1: ( 'Recent' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1508:3: 'Recent'
                    {
                    match(input,24,FOLLOW_24_in_rule__Context__Alternatives3192); 

                    }

                     after(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1513:6: ( ( 'Unrestricted' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1513:6: ( ( 'Unrestricted' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1514:1: ( 'Unrestricted' )
                    {
                     before(grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1515:1: ( 'Unrestricted' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1515:3: 'Unrestricted'
                    {
                    match(input,25,FOLLOW_25_in_rule__Context__Alternatives3213); 

                    }

                     after(grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__Alternatives"


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1527:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1531:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1532:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__03246);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__03249);
            rule__PackageDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1539:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1543:1: ( ( 'package' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1544:1: ( 'package' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1544:1: ( 'package' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1545:1: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl3277); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1558:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1562:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1563:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__13308);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__13311);
            rule__PackageDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1570:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1574:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1575:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1575:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1576:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1577:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1577:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl3338);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1587:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1591:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1592:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__23368);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__23371);
            rule__PackageDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2"


    // $ANTLR start "rule__PackageDeclaration__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1599:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1603:1: ( ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1604:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1604:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1605:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1606:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=29 && LA12_0<=30)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1606:2: rule__PackageDeclaration__UsagesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl3398);
            	    rule__PackageDeclaration__UsagesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getPackageDeclarationAccess().getUsagesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1616:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1620:1: ( rule__PackageDeclaration__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1621:2: rule__PackageDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33429);
            rule__PackageDeclaration__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__3"


    // $ANTLR start "rule__PackageDeclaration__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1627:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1631:1: ( ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1632:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1632:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1633:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1634:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1634:2: rule__PackageDeclaration__ModelAssignment_3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3456);
            rule__PackageDeclaration__ModelAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getModelAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__3__Impl"


    // $ANTLR start "rule__DOUBLE__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1652:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1656:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1657:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03494);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03497);
            rule__DOUBLE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0"


    // $ANTLR start "rule__DOUBLE__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1664:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1668:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1669:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1669:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1670:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3524); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1681:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1685:1: ( rule__DOUBLE__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1686:2: rule__DOUBLE__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13553);
            rule__DOUBLE__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1"


    // $ANTLR start "rule__DOUBLE__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1692:1: rule__DOUBLE__Group__1__Impl : ( ( rule__DOUBLE__Group_1__0 )? ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1696:1: ( ( ( rule__DOUBLE__Group_1__0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1697:1: ( ( rule__DOUBLE__Group_1__0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1697:1: ( ( rule__DOUBLE__Group_1__0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1698:1: ( rule__DOUBLE__Group_1__0 )?
            {
             before(grammarAccess.getDOUBLEAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1699:1: ( rule__DOUBLE__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1699:2: rule__DOUBLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3580);
                    rule__DOUBLE__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDOUBLEAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group__1__Impl"


    // $ANTLR start "rule__DOUBLE__Group_1__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1713:1: rule__DOUBLE__Group_1__0 : rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 ;
    public final void rule__DOUBLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1717:1: ( rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1718:2: rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03615);
            rule__DOUBLE__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03618);
            rule__DOUBLE__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group_1__0"


    // $ANTLR start "rule__DOUBLE__Group_1__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1725:1: rule__DOUBLE__Group_1__0__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1729:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1730:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1730:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1731:1: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3646); 
             after(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group_1__0__Impl"


    // $ANTLR start "rule__DOUBLE__Group_1__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1744:1: rule__DOUBLE__Group_1__1 : rule__DOUBLE__Group_1__1__Impl ;
    public final void rule__DOUBLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1748:1: ( rule__DOUBLE__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1749:2: rule__DOUBLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13677);
            rule__DOUBLE__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group_1__1"


    // $ANTLR start "rule__DOUBLE__Group_1__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1755:1: rule__DOUBLE__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1759:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1760:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1760:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1761:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3704); 
             after(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DOUBLE__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1776:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1780:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1781:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03737);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03740);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1788:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1792:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1793:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1793:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1794:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3767); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1805:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1809:1: ( rule__QualifiedName__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1810:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13796);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1816:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1820:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1821:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1821:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1822:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1823:1: ( rule__QualifiedName__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==27) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1823:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3823);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1837:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1841:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1842:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03858);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03861);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1849:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1853:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1854:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1854:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1855:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3889); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1868:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1872:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1873:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13920);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1879:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1883:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1884:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1884:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1885:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3947); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1900:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1904:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1905:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03980);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03983);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1912:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1916:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1917:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1917:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1918:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl4010);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1929:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1933:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1934:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__14039);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1940:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1944:1: ( ( ( '.*' )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( ( '.*' )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( ( '.*' )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1946:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1947:1: ( '.*' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1948:2: '.*'
                    {
                    match(input,28,FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl4068); 

                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__IQUsage__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1963:1: rule__IQUsage__Group__0 : rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 ;
    public final void rule__IQUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1967:1: ( rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1968:2: rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__04105);
            rule__IQUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__04108);
            rule__IQUsage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQUsage__Group__0"


    // $ANTLR start "rule__IQUsage__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1975:1: rule__IQUsage__Group__0__Impl : ( 'uses-incquery-patterns' ) ;
    public final void rule__IQUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1979:1: ( ( 'uses-incquery-patterns' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1980:1: ( 'uses-incquery-patterns' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1980:1: ( 'uses-incquery-patterns' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1981:1: 'uses-incquery-patterns'
            {
             before(grammarAccess.getIQUsageAccess().getUsesIncqueryPatternsKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__IQUsage__Group__0__Impl4136); 
             after(grammarAccess.getIQUsageAccess().getUsesIncqueryPatternsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQUsage__Group__0__Impl"


    // $ANTLR start "rule__IQUsage__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1994:1: rule__IQUsage__Group__1 : rule__IQUsage__Group__1__Impl ;
    public final void rule__IQUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1998:1: ( rule__IQUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1999:2: rule__IQUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__14167);
            rule__IQUsage__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQUsage__Group__1"


    // $ANTLR start "rule__IQUsage__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2005:1: rule__IQUsage__Group__1__Impl : ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__IQUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2009:1: ( ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2010:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2010:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2011:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2012:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2012:2: rule__IQUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl4194);
            rule__IQUsage__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIQUsageAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQUsage__Group__1__Impl"


    // $ANTLR start "rule__EventSourceUsage__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2026:1: rule__EventSourceUsage__Group__0 : rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 ;
    public final void rule__EventSourceUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2030:1: ( rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2031:2: rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__04228);
            rule__EventSourceUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__04231);
            rule__EventSourceUsage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSourceUsage__Group__0"


    // $ANTLR start "rule__EventSourceUsage__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2038:1: rule__EventSourceUsage__Group__0__Impl : ( 'uses-eventsources' ) ;
    public final void rule__EventSourceUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2042:1: ( ( 'uses-eventsources' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2043:1: ( 'uses-eventsources' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2043:1: ( 'uses-eventsources' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2044:1: 'uses-eventsources'
            {
             before(grammarAccess.getEventSourceUsageAccess().getUsesEventsourcesKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl4259); 
             after(grammarAccess.getEventSourceUsageAccess().getUsesEventsourcesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSourceUsage__Group__0__Impl"


    // $ANTLR start "rule__EventSourceUsage__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2057:1: rule__EventSourceUsage__Group__1 : rule__EventSourceUsage__Group__1__Impl ;
    public final void rule__EventSourceUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2061:1: ( rule__EventSourceUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2062:2: rule__EventSourceUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__14290);
            rule__EventSourceUsage__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSourceUsage__Group__1"


    // $ANTLR start "rule__EventSourceUsage__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2068:1: rule__EventSourceUsage__Group__1__Impl : ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__EventSourceUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2072:1: ( ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2073:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2073:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2074:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2075:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2075:2: rule__EventSourceUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl4317);
            rule__EventSourceUsage__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSourceUsage__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2089:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2093:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2094:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04351);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04354);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2101:1: rule__Model__Group__0__Impl : ( ( rule__Model__AnnotationsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2105:1: ( ( ( rule__Model__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2106:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2106:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2107:1: ( rule__Model__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2108:1: ( rule__Model__AnnotationsAssignment_0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=46 && LA16_0<=48)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2108:2: rule__Model__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl4381);
            	    rule__Model__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2118:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2122:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2123:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14412);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14415);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2130:1: rule__Model__Group__1__Impl : ( 'EventModel' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2134:1: ( ( 'EventModel' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2135:1: ( 'EventModel' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2135:1: ( 'EventModel' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2136:1: 'EventModel'
            {
             before(grammarAccess.getModelAccess().getEventModelKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__Model__Group__1__Impl4443); 
             after(grammarAccess.getModelAccess().getEventModelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2149:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2153:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2154:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24474);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24477);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2161:1: rule__Model__Group__2__Impl : ( ( rule__Model__NameAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2165:1: ( ( ( rule__Model__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2166:1: ( ( rule__Model__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2166:1: ( ( rule__Model__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2167:1: ( rule__Model__NameAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2168:1: ( rule__Model__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2168:2: rule__Model__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4504);
            rule__Model__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2178:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2182:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2183:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34534);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34537);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2190:1: rule__Model__Group__3__Impl : ( '{' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2194:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2195:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2195:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2196:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__Model__Group__3__Impl4565); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2209:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2213:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2214:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44596);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44599);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2221:1: rule__Model__Group__4__Impl : ( ( rule__Model__EventsAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2225:1: ( ( ( rule__Model__EventsAssignment_4 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2226:1: ( ( rule__Model__EventsAssignment_4 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2226:1: ( ( rule__Model__EventsAssignment_4 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2227:1: ( rule__Model__EventsAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getEventsAssignment_4()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2228:1: ( rule__Model__EventsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==34||LA17_0==40||LA17_0==43||(LA17_0>=46 && LA17_0<=48)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2228:2: rule__Model__EventsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4626);
            	    rule__Model__EventsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getEventsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2238:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2242:1: ( rule__Model__Group__5__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2243:2: rule__Model__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54657);
            rule__Model__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2249:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2253:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2254:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2254:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2255:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,33,FOLLOW_33_in_rule__Model__Group__5__Impl4685); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2280:1: rule__AtomicEvent__Group__0 : rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 ;
    public final void rule__AtomicEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2284:1: ( rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2285:2: rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04728);
            rule__AtomicEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04731);
            rule__AtomicEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__0"


    // $ANTLR start "rule__AtomicEvent__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2292:1: rule__AtomicEvent__Group__0__Impl : ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__AtomicEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2296:1: ( ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2297:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2297:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2298:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2299:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=46 && LA18_0<=48)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2299:2: rule__AtomicEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4758);
            	    rule__AtomicEvent__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getAtomicEventAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__0__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2309:1: rule__AtomicEvent__Group__1 : rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 ;
    public final void rule__AtomicEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2313:1: ( rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2314:2: rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14789);
            rule__AtomicEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14792);
            rule__AtomicEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__1"


    // $ANTLR start "rule__AtomicEvent__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2321:1: rule__AtomicEvent__Group__1__Impl : ( 'AtomicEvent' ) ;
    public final void rule__AtomicEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2325:1: ( ( 'AtomicEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2326:1: ( 'AtomicEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2326:1: ( 'AtomicEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2327:1: 'AtomicEvent'
            {
             before(grammarAccess.getAtomicEventAccess().getAtomicEventKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4820); 
             after(grammarAccess.getAtomicEventAccess().getAtomicEventKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__1__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2340:1: rule__AtomicEvent__Group__2 : rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 ;
    public final void rule__AtomicEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2344:1: ( rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2345:2: rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24851);
            rule__AtomicEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24854);
            rule__AtomicEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__2"


    // $ANTLR start "rule__AtomicEvent__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2352:1: rule__AtomicEvent__Group__2__Impl : ( ( rule__AtomicEvent__NameAssignment_2 ) ) ;
    public final void rule__AtomicEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2356:1: ( ( ( rule__AtomicEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2357:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2357:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2358:1: ( rule__AtomicEvent__NameAssignment_2 )
            {
             before(grammarAccess.getAtomicEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2359:1: ( rule__AtomicEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2359:2: rule__AtomicEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4881);
            rule__AtomicEvent__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__2__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2369:1: rule__AtomicEvent__Group__3 : rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 ;
    public final void rule__AtomicEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2373:1: ( rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2374:2: rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34911);
            rule__AtomicEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34914);
            rule__AtomicEvent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__3"


    // $ANTLR start "rule__AtomicEvent__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2381:1: rule__AtomicEvent__Group__3__Impl : ( '()' ) ;
    public final void rule__AtomicEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2385:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2386:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2386:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2387:1: '()'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftParenthesisRightParenthesisKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl4942); 
             after(grammarAccess.getAtomicEventAccess().getLeftParenthesisRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__3__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2400:1: rule__AtomicEvent__Group__4 : rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 ;
    public final void rule__AtomicEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2404:1: ( rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2405:2: rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__44973);
            rule__AtomicEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__44976);
            rule__AtomicEvent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__4"


    // $ANTLR start "rule__AtomicEvent__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2412:1: rule__AtomicEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2416:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2417:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2417:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2418:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl5004); 
             after(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__4__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__5"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2431:1: rule__AtomicEvent__Group__5 : rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 ;
    public final void rule__AtomicEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2435:1: ( rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2436:2: rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__55035);
            rule__AtomicEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__55038);
            rule__AtomicEvent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__5"


    // $ANTLR start "rule__AtomicEvent__Group__5__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2443:1: rule__AtomicEvent__Group__5__Impl : ( 'id' ) ;
    public final void rule__AtomicEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2447:1: ( ( 'id' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2448:1: ( 'id' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2448:1: ( 'id' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2449:1: 'id'
            {
             before(grammarAccess.getAtomicEventAccess().getIdKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl5066); 
             after(grammarAccess.getAtomicEventAccess().getIdKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__5__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__6"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2462:1: rule__AtomicEvent__Group__6 : rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 ;
    public final void rule__AtomicEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2466:1: ( rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2467:2: rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__65097);
            rule__AtomicEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__65100);
            rule__AtomicEvent__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__6"


    // $ANTLR start "rule__AtomicEvent__Group__6__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2474:1: rule__AtomicEvent__Group__6__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2478:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2479:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2479:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2480:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl5128); 
             after(grammarAccess.getAtomicEventAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__6__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__7"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2493:1: rule__AtomicEvent__Group__7 : rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 ;
    public final void rule__AtomicEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2497:1: ( rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2498:2: rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__75159);
            rule__AtomicEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__75162);
            rule__AtomicEvent__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__7"


    // $ANTLR start "rule__AtomicEvent__Group__7__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2505:1: rule__AtomicEvent__Group__7__Impl : ( ( rule__AtomicEvent__IdAssignment_7 ) ) ;
    public final void rule__AtomicEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2509:1: ( ( ( rule__AtomicEvent__IdAssignment_7 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2510:1: ( ( rule__AtomicEvent__IdAssignment_7 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2510:1: ( ( rule__AtomicEvent__IdAssignment_7 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2511:1: ( rule__AtomicEvent__IdAssignment_7 )
            {
             before(grammarAccess.getAtomicEventAccess().getIdAssignment_7()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2512:1: ( rule__AtomicEvent__IdAssignment_7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2512:2: rule__AtomicEvent__IdAssignment_7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__IdAssignment_7_in_rule__AtomicEvent__Group__7__Impl5189);
            rule__AtomicEvent__IdAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getIdAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__7__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__8"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2522:1: rule__AtomicEvent__Group__8 : rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 ;
    public final void rule__AtomicEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2526:1: ( rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2527:2: rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__85219);
            rule__AtomicEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__85222);
            rule__AtomicEvent__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__8"


    // $ANTLR start "rule__AtomicEvent__Group__8__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2534:1: rule__AtomicEvent__Group__8__Impl : ( 'source' ) ;
    public final void rule__AtomicEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2538:1: ( ( 'source' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2539:1: ( 'source' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2539:1: ( 'source' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2540:1: 'source'
            {
             before(grammarAccess.getAtomicEventAccess().getSourceKeyword_8()); 
            match(input,38,FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl5250); 
             after(grammarAccess.getAtomicEventAccess().getSourceKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__8__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__9"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2553:1: rule__AtomicEvent__Group__9 : rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 ;
    public final void rule__AtomicEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2557:1: ( rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2558:2: rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__95281);
            rule__AtomicEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__95284);
            rule__AtomicEvent__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__9"


    // $ANTLR start "rule__AtomicEvent__Group__9__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2565:1: rule__AtomicEvent__Group__9__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2569:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2570:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2570:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2571:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_9()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl5312); 
             after(grammarAccess.getAtomicEventAccess().getColonKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__9__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__10"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2584:1: rule__AtomicEvent__Group__10 : rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 ;
    public final void rule__AtomicEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2588:1: ( rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2589:2: rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__105343);
            rule__AtomicEvent__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__105346);
            rule__AtomicEvent__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__10"


    // $ANTLR start "rule__AtomicEvent__Group__10__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2596:1: rule__AtomicEvent__Group__10__Impl : ( ( rule__AtomicEvent__SourceAssignment_10 ) ) ;
    public final void rule__AtomicEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2600:1: ( ( ( rule__AtomicEvent__SourceAssignment_10 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2601:1: ( ( rule__AtomicEvent__SourceAssignment_10 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2601:1: ( ( rule__AtomicEvent__SourceAssignment_10 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2602:1: ( rule__AtomicEvent__SourceAssignment_10 )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceAssignment_10()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2603:1: ( rule__AtomicEvent__SourceAssignment_10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2603:2: rule__AtomicEvent__SourceAssignment_10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__SourceAssignment_10_in_rule__AtomicEvent__Group__10__Impl5373);
            rule__AtomicEvent__SourceAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getSourceAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__10__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__11"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2613:1: rule__AtomicEvent__Group__11 : rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 ;
    public final void rule__AtomicEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2617:1: ( rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2618:2: rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__115403);
            rule__AtomicEvent__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__115406);
            rule__AtomicEvent__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__11"


    // $ANTLR start "rule__AtomicEvent__Group__11__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2625:1: rule__AtomicEvent__Group__11__Impl : ( 'parameterFilters' ) ;
    public final void rule__AtomicEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2629:1: ( ( 'parameterFilters' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2630:1: ( 'parameterFilters' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2630:1: ( 'parameterFilters' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2631:1: 'parameterFilters'
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersKeyword_11()); 
            match(input,39,FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5434); 
             after(grammarAccess.getAtomicEventAccess().getParameterFiltersKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__11__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__12"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2644:1: rule__AtomicEvent__Group__12 : rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 ;
    public final void rule__AtomicEvent__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2648:1: ( rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2649:2: rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125465);
            rule__AtomicEvent__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125468);
            rule__AtomicEvent__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__12"


    // $ANTLR start "rule__AtomicEvent__Group__12__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2656:1: rule__AtomicEvent__Group__12__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2660:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2661:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2661:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2662:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_12()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5496); 
             after(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__12__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__13"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2675:1: rule__AtomicEvent__Group__13 : rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 ;
    public final void rule__AtomicEvent__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2679:1: ( rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2680:2: rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135527);
            rule__AtomicEvent__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135530);
            rule__AtomicEvent__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__13"


    // $ANTLR start "rule__AtomicEvent__Group__13__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2687:1: rule__AtomicEvent__Group__13__Impl : ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) ;
    public final void rule__AtomicEvent__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2691:1: ( ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2692:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2692:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2693:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2693:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2694:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2695:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2695:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5559);
            rule__AtomicEvent__ParameterFiltersAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 

            }

            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2698:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2699:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2700:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2700:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5571);
            	    rule__AtomicEvent__ParameterFiltersAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__13__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__14"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2711:1: rule__AtomicEvent__Group__14 : rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 ;
    public final void rule__AtomicEvent__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2715:1: ( rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2716:2: rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145604);
            rule__AtomicEvent__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145607);
            rule__AtomicEvent__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__14"


    // $ANTLR start "rule__AtomicEvent__Group__14__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2723:1: rule__AtomicEvent__Group__14__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2727:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2728:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2728:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2729:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_14()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5635); 
             after(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__14__Impl"


    // $ANTLR start "rule__AtomicEvent__Group__15"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2742:1: rule__AtomicEvent__Group__15 : rule__AtomicEvent__Group__15__Impl ;
    public final void rule__AtomicEvent__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2746:1: ( rule__AtomicEvent__Group__15__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2747:2: rule__AtomicEvent__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155666);
            rule__AtomicEvent__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__15"


    // $ANTLR start "rule__AtomicEvent__Group__15__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2753:1: rule__AtomicEvent__Group__15__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2757:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2758:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2758:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2759:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_15()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5694); 
             after(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__Group__15__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2804:1: rule__IQPatternEvent__Group__0 : rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 ;
    public final void rule__IQPatternEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2808:1: ( rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2809:2: rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05757);
            rule__IQPatternEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05760);
            rule__IQPatternEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__0"


    // $ANTLR start "rule__IQPatternEvent__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2816:1: rule__IQPatternEvent__Group__0__Impl : ( 'IQPatternEvent' ) ;
    public final void rule__IQPatternEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2820:1: ( ( 'IQPatternEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2821:1: ( 'IQPatternEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2821:1: ( 'IQPatternEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2822:1: 'IQPatternEvent'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternEventKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5788); 
             after(grammarAccess.getIQPatternEventAccess().getIQPatternEventKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__0__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2835:1: rule__IQPatternEvent__Group__1 : rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 ;
    public final void rule__IQPatternEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2839:1: ( rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2840:2: rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15819);
            rule__IQPatternEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15822);
            rule__IQPatternEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__1"


    // $ANTLR start "rule__IQPatternEvent__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2847:1: rule__IQPatternEvent__Group__1__Impl : ( ( rule__IQPatternEvent__NameAssignment_1 ) ) ;
    public final void rule__IQPatternEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2851:1: ( ( ( rule__IQPatternEvent__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2852:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2852:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2853:1: ( rule__IQPatternEvent__NameAssignment_1 )
            {
             before(grammarAccess.getIQPatternEventAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2854:1: ( rule__IQPatternEvent__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2854:2: rule__IQPatternEvent__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5849);
            rule__IQPatternEvent__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternEventAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__1__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2864:1: rule__IQPatternEvent__Group__2 : rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 ;
    public final void rule__IQPatternEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2868:1: ( rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2869:2: rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25879);
            rule__IQPatternEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25882);
            rule__IQPatternEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__2"


    // $ANTLR start "rule__IQPatternEvent__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2876:1: rule__IQPatternEvent__Group__2__Impl : ( '()' ) ;
    public final void rule__IQPatternEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2880:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2881:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2881:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2882:1: '()'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftParenthesisRightParenthesisKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5910); 
             after(grammarAccess.getIQPatternEventAccess().getLeftParenthesisRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__2__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2895:1: rule__IQPatternEvent__Group__3 : rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 ;
    public final void rule__IQPatternEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2899:1: ( rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2900:2: rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__35941);
            rule__IQPatternEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__35944);
            rule__IQPatternEvent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__3"


    // $ANTLR start "rule__IQPatternEvent__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2907:1: rule__IQPatternEvent__Group__3__Impl : ( '{' ) ;
    public final void rule__IQPatternEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2911:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2912:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2912:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2913:1: '{'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl5972); 
             after(grammarAccess.getIQPatternEventAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__3__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2926:1: rule__IQPatternEvent__Group__4 : rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 ;
    public final void rule__IQPatternEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2930:1: ( rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2931:2: rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__46003);
            rule__IQPatternEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__46006);
            rule__IQPatternEvent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__4"


    // $ANTLR start "rule__IQPatternEvent__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2938:1: rule__IQPatternEvent__Group__4__Impl : ( 'IQPatternRef' ) ;
    public final void rule__IQPatternEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2942:1: ( ( 'IQPatternRef' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2943:1: ( 'IQPatternRef' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2943:1: ( 'IQPatternRef' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2944:1: 'IQPatternRef'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternRefKeyword_4()); 
            match(input,41,FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl6034); 
             after(grammarAccess.getIQPatternEventAccess().getIQPatternRefKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__4__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__5"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2957:1: rule__IQPatternEvent__Group__5 : rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 ;
    public final void rule__IQPatternEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2961:1: ( rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2962:2: rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__56065);
            rule__IQPatternEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__56068);
            rule__IQPatternEvent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__5"


    // $ANTLR start "rule__IQPatternEvent__Group__5__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2969:1: rule__IQPatternEvent__Group__5__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2973:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2974:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2974:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2975:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_5()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl6096); 
             after(grammarAccess.getIQPatternEventAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__5__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__6"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2988:1: rule__IQPatternEvent__Group__6 : rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 ;
    public final void rule__IQPatternEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2992:1: ( rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2993:2: rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__66127);
            rule__IQPatternEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__66130);
            rule__IQPatternEvent__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__6"


    // $ANTLR start "rule__IQPatternEvent__Group__6__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3000:1: rule__IQPatternEvent__Group__6__Impl : ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) ;
    public final void rule__IQPatternEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3004:1: ( ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3005:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3005:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3006:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternAssignment_6()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3007:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3007:2: rule__IQPatternEvent__IqpatternAssignment_6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl6157);
            rule__IQPatternEvent__IqpatternAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternEventAccess().getIqpatternAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__6__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__7"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3017:1: rule__IQPatternEvent__Group__7 : rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 ;
    public final void rule__IQPatternEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3021:1: ( rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3022:2: rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__76187);
            rule__IQPatternEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__76190);
            rule__IQPatternEvent__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__7"


    // $ANTLR start "rule__IQPatternEvent__Group__7__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3029:1: rule__IQPatternEvent__Group__7__Impl : ( 'ChangeType' ) ;
    public final void rule__IQPatternEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3033:1: ( ( 'ChangeType' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3034:1: ( 'ChangeType' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3034:1: ( 'ChangeType' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3035:1: 'ChangeType'
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeKeyword_7()); 
            match(input,42,FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl6218); 
             after(grammarAccess.getIQPatternEventAccess().getChangeTypeKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__7__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__8"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3048:1: rule__IQPatternEvent__Group__8 : rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 ;
    public final void rule__IQPatternEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3052:1: ( rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3053:2: rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__86249);
            rule__IQPatternEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__86252);
            rule__IQPatternEvent__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__8"


    // $ANTLR start "rule__IQPatternEvent__Group__8__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3060:1: rule__IQPatternEvent__Group__8__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3064:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3065:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3065:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3066:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl6280); 
             after(grammarAccess.getIQPatternEventAccess().getColonKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__8__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__9"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3079:1: rule__IQPatternEvent__Group__9 : rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 ;
    public final void rule__IQPatternEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3083:1: ( rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3084:2: rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__96311);
            rule__IQPatternEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__96314);
            rule__IQPatternEvent__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__9"


    // $ANTLR start "rule__IQPatternEvent__Group__9__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3091:1: rule__IQPatternEvent__Group__9__Impl : ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) ;
    public final void rule__IQPatternEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3095:1: ( ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3096:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3096:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3097:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeAssignment_9()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3098:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3098:2: rule__IQPatternEvent__ChangeTypeAssignment_9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl6341);
            rule__IQPatternEvent__ChangeTypeAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternEventAccess().getChangeTypeAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__9__Impl"


    // $ANTLR start "rule__IQPatternEvent__Group__10"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3108:1: rule__IQPatternEvent__Group__10 : rule__IQPatternEvent__Group__10__Impl ;
    public final void rule__IQPatternEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3112:1: ( rule__IQPatternEvent__Group__10__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3113:2: rule__IQPatternEvent__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__106371);
            rule__IQPatternEvent__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__10"


    // $ANTLR start "rule__IQPatternEvent__Group__10__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3119:1: rule__IQPatternEvent__Group__10__Impl : ( '}' ) ;
    public final void rule__IQPatternEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3123:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3124:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3124:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3125:1: '}'
            {
             before(grammarAccess.getIQPatternEventAccess().getRightCurlyBracketKeyword_10()); 
            match(input,33,FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl6399); 
             after(grammarAccess.getIQPatternEventAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__Group__10__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3160:1: rule__ComplexEvent__Group__0 : rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 ;
    public final void rule__ComplexEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3164:1: ( rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3165:2: rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06452);
            rule__ComplexEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06455);
            rule__ComplexEvent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__0"


    // $ANTLR start "rule__ComplexEvent__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3172:1: rule__ComplexEvent__Group__0__Impl : ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__ComplexEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3176:1: ( ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3177:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3177:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3178:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3179:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=46 && LA20_0<=48)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3179:2: rule__ComplexEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6482);
            	    rule__ComplexEvent__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getComplexEventAccess().getAnnotationsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__0__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3189:1: rule__ComplexEvent__Group__1 : rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 ;
    public final void rule__ComplexEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3193:1: ( rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3194:2: rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16513);
            rule__ComplexEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16516);
            rule__ComplexEvent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__1"


    // $ANTLR start "rule__ComplexEvent__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3201:1: rule__ComplexEvent__Group__1__Impl : ( 'ComplexEvent' ) ;
    public final void rule__ComplexEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3205:1: ( ( 'ComplexEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3206:1: ( 'ComplexEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3206:1: ( 'ComplexEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3207:1: 'ComplexEvent'
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventKeyword_1()); 
            match(input,43,FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6544); 
             after(grammarAccess.getComplexEventAccess().getComplexEventKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__1__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3220:1: rule__ComplexEvent__Group__2 : rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 ;
    public final void rule__ComplexEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3224:1: ( rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3225:2: rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26575);
            rule__ComplexEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26578);
            rule__ComplexEvent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__2"


    // $ANTLR start "rule__ComplexEvent__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3232:1: rule__ComplexEvent__Group__2__Impl : ( ( rule__ComplexEvent__NameAssignment_2 ) ) ;
    public final void rule__ComplexEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3236:1: ( ( ( rule__ComplexEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3237:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3237:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3238:1: ( rule__ComplexEvent__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3239:1: ( rule__ComplexEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3239:2: rule__ComplexEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6605);
            rule__ComplexEvent__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComplexEventAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__2__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3249:1: rule__ComplexEvent__Group__3 : rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 ;
    public final void rule__ComplexEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3253:1: ( rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3254:2: rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36635);
            rule__ComplexEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36638);
            rule__ComplexEvent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__3"


    // $ANTLR start "rule__ComplexEvent__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3261:1: rule__ComplexEvent__Group__3__Impl : ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) ;
    public final void rule__ComplexEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3265:1: ( ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3266:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3266:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3267:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            {
             before(grammarAccess.getComplexEventAccess().getParamlistAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3268:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3268:2: rule__ComplexEvent__ParamlistAssignment_3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6665);
            rule__ComplexEvent__ParamlistAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getComplexEventAccess().getParamlistAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__3__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3278:1: rule__ComplexEvent__Group__4 : rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 ;
    public final void rule__ComplexEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3282:1: ( rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3283:2: rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46695);
            rule__ComplexEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46698);
            rule__ComplexEvent__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__4"


    // $ANTLR start "rule__ComplexEvent__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3290:1: rule__ComplexEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__ComplexEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3294:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3295:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3295:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3296:1: '{'
            {
             before(grammarAccess.getComplexEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6726); 
             after(grammarAccess.getComplexEventAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__4__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__5"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3309:1: rule__ComplexEvent__Group__5 : rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6 ;
    public final void rule__ComplexEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3313:1: ( rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3314:2: rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56757);
            rule__ComplexEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__6_in_rule__ComplexEvent__Group__56760);
            rule__ComplexEvent__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__5"


    // $ANTLR start "rule__ComplexEvent__Group__5__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3321:1: rule__ComplexEvent__Group__5__Impl : ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* ) ;
    public final void rule__ComplexEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3325:1: ( ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3326:1: ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3326:1: ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3327:1: ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )*
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventExpressionsAssignment_5()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3328:1: ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3328:2: rule__ComplexEvent__ComplexEventExpressionsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__ComplexEvent__ComplexEventExpressionsAssignment_5_in_rule__ComplexEvent__Group__5__Impl6787);
            	    rule__ComplexEvent__ComplexEventExpressionsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getComplexEventAccess().getComplexEventExpressionsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__5__Impl"


    // $ANTLR start "rule__ComplexEvent__Group__6"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3338:1: rule__ComplexEvent__Group__6 : rule__ComplexEvent__Group__6__Impl ;
    public final void rule__ComplexEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3342:1: ( rule__ComplexEvent__Group__6__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3343:2: rule__ComplexEvent__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__6__Impl_in_rule__ComplexEvent__Group__66818);
            rule__ComplexEvent__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__6"


    // $ANTLR start "rule__ComplexEvent__Group__6__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3349:1: rule__ComplexEvent__Group__6__Impl : ( '}' ) ;
    public final void rule__ComplexEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3353:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3354:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3354:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3355:1: '}'
            {
             before(grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_6()); 
            match(input,33,FOLLOW_33_in_rule__ComplexEvent__Group__6__Impl6846); 
             after(grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__Group__6__Impl"


    // $ANTLR start "rule__CEParamlist__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3382:1: rule__CEParamlist__Group__0 : rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 ;
    public final void rule__CEParamlist__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3386:1: ( rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3387:2: rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06891);
            rule__CEParamlist__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06894);
            rule__CEParamlist__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__0"


    // $ANTLR start "rule__CEParamlist__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3394:1: rule__CEParamlist__Group__0__Impl : ( () ) ;
    public final void rule__CEParamlist__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3398:1: ( ( () ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3399:1: ( () )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3399:1: ( () )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3400:1: ()
            {
             before(grammarAccess.getCEParamlistAccess().getCEParamlistAction_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3401:1: ()
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3403:1: 
            {
            }

             after(grammarAccess.getCEParamlistAccess().getCEParamlistAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__0__Impl"


    // $ANTLR start "rule__CEParamlist__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3413:1: rule__CEParamlist__Group__1 : rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 ;
    public final void rule__CEParamlist__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3417:1: ( rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3418:2: rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__16952);
            rule__CEParamlist__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__16955);
            rule__CEParamlist__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__1"


    // $ANTLR start "rule__CEParamlist__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3425:1: rule__CEParamlist__Group__1__Impl : ( '(' ) ;
    public final void rule__CEParamlist__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3429:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3430:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3430:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3431:1: '('
            {
             before(grammarAccess.getCEParamlistAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__CEParamlist__Group__1__Impl6983); 
             after(grammarAccess.getCEParamlistAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__1__Impl"


    // $ANTLR start "rule__CEParamlist__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3444:1: rule__CEParamlist__Group__2 : rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 ;
    public final void rule__CEParamlist__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3448:1: ( rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3449:2: rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__27014);
            rule__CEParamlist__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__27017);
            rule__CEParamlist__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__2"


    // $ANTLR start "rule__CEParamlist__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3456:1: rule__CEParamlist__Group__2__Impl : ( ( rule__CEParamlist__ParamsAssignment_2 )* ) ;
    public final void rule__CEParamlist__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3460:1: ( ( ( rule__CEParamlist__ParamsAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3461:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3461:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3462:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            {
             before(grammarAccess.getCEParamlistAccess().getParamsAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3463:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3463:2: rule__CEParamlist__ParamsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl7044);
            	    rule__CEParamlist__ParamsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getCEParamlistAccess().getParamsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__2__Impl"


    // $ANTLR start "rule__CEParamlist__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3473:1: rule__CEParamlist__Group__3 : rule__CEParamlist__Group__3__Impl ;
    public final void rule__CEParamlist__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3477:1: ( rule__CEParamlist__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3478:2: rule__CEParamlist__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__37075);
            rule__CEParamlist__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__3"


    // $ANTLR start "rule__CEParamlist__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3484:1: rule__CEParamlist__Group__3__Impl : ( ')' ) ;
    public final void rule__CEParamlist__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3488:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3489:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3489:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3490:1: ')'
            {
             before(grammarAccess.getCEParamlistAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__CEParamlist__Group__3__Impl7103); 
             after(grammarAccess.getCEParamlistAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__Group__3__Impl"


    // $ANTLR start "rule__EventParamWithType__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3511:1: rule__EventParamWithType__Group__0 : rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1 ;
    public final void rule__EventParamWithType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3515:1: ( rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3516:2: rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__0__Impl_in_rule__EventParamWithType__Group__07142);
            rule__EventParamWithType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventParamWithType__Group__1_in_rule__EventParamWithType__Group__07145);
            rule__EventParamWithType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__0"


    // $ANTLR start "rule__EventParamWithType__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3523:1: rule__EventParamWithType__Group__0__Impl : ( ( rule__EventParamWithType__NameAssignment_0 ) ) ;
    public final void rule__EventParamWithType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3527:1: ( ( ( rule__EventParamWithType__NameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3528:1: ( ( rule__EventParamWithType__NameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3528:1: ( ( rule__EventParamWithType__NameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3529:1: ( rule__EventParamWithType__NameAssignment_0 )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3530:1: ( rule__EventParamWithType__NameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3530:2: rule__EventParamWithType__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__EventParamWithType__NameAssignment_0_in_rule__EventParamWithType__Group__0__Impl7172);
            rule__EventParamWithType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEventParamWithTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__0__Impl"


    // $ANTLR start "rule__EventParamWithType__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3540:1: rule__EventParamWithType__Group__1 : rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2 ;
    public final void rule__EventParamWithType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3544:1: ( rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3545:2: rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__1__Impl_in_rule__EventParamWithType__Group__17202);
            rule__EventParamWithType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventParamWithType__Group__2_in_rule__EventParamWithType__Group__17205);
            rule__EventParamWithType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__1"


    // $ANTLR start "rule__EventParamWithType__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3552:1: rule__EventParamWithType__Group__1__Impl : ( ':' ) ;
    public final void rule__EventParamWithType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3556:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3557:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3557:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3558:1: ':'
            {
             before(grammarAccess.getEventParamWithTypeAccess().getColonKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__EventParamWithType__Group__1__Impl7233); 
             after(grammarAccess.getEventParamWithTypeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__1__Impl"


    // $ANTLR start "rule__EventParamWithType__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3571:1: rule__EventParamWithType__Group__2 : rule__EventParamWithType__Group__2__Impl ;
    public final void rule__EventParamWithType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3575:1: ( rule__EventParamWithType__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3576:2: rule__EventParamWithType__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__2__Impl_in_rule__EventParamWithType__Group__27264);
            rule__EventParamWithType__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__2"


    // $ANTLR start "rule__EventParamWithType__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3582:1: rule__EventParamWithType__Group__2__Impl : ( ( rule__EventParamWithType__TypeAssignment_2 ) ) ;
    public final void rule__EventParamWithType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3586:1: ( ( ( rule__EventParamWithType__TypeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3587:1: ( ( rule__EventParamWithType__TypeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3587:1: ( ( rule__EventParamWithType__TypeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3588:1: ( rule__EventParamWithType__TypeAssignment_2 )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3589:1: ( rule__EventParamWithType__TypeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3589:2: rule__EventParamWithType__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__EventParamWithType__TypeAssignment_2_in_rule__EventParamWithType__Group__2__Impl7291);
            rule__EventParamWithType__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEventParamWithTypeAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__Group__2__Impl"


    // $ANTLR start "rule__ParameterFilter__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3605:1: rule__ParameterFilter__Group__0 : rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 ;
    public final void rule__ParameterFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3609:1: ( rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3610:2: rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__07327);
            rule__ParameterFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__07330);
            rule__ParameterFilter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__Group__0"


    // $ANTLR start "rule__ParameterFilter__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3617:1: rule__ParameterFilter__Group__0__Impl : ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) ;
    public final void rule__ParameterFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3621:1: ( ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3622:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3622:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3623:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3624:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3624:2: rule__ParameterFilter__AttributeNameAssignment_0
            {
            pushFollow(FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl7357);
            rule__ParameterFilter__AttributeNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterFilterAccess().getAttributeNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__Group__0__Impl"


    // $ANTLR start "rule__ParameterFilter__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3634:1: rule__ParameterFilter__Group__1 : rule__ParameterFilter__Group__1__Impl ;
    public final void rule__ParameterFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3638:1: ( rule__ParameterFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3639:2: rule__ParameterFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__17387);
            rule__ParameterFilter__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__Group__1"


    // $ANTLR start "rule__ParameterFilter__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3645:1: rule__ParameterFilter__Group__1__Impl : ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) ;
    public final void rule__ParameterFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3649:1: ( ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3650:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3650:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3651:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3652:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3652:2: rule__ParameterFilter__ParamFilterRuleAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl7414);
            rule__ParameterFilter__ParamFilterRuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterFilterAccess().getParamFilterRuleAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__Group__1__Impl"


    // $ANTLR start "rule__ContextAnnotation__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3666:1: rule__ContextAnnotation__Group__0 : rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 ;
    public final void rule__ContextAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3670:1: ( rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3671:2: rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__07448);
            rule__ContextAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__07451);
            rule__ContextAnnotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__0"


    // $ANTLR start "rule__ContextAnnotation__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3678:1: rule__ContextAnnotation__Group__0__Impl : ( '@Context' ) ;
    public final void rule__ContextAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3682:1: ( ( '@Context' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3683:1: ( '@Context' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3683:1: ( '@Context' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3684:1: '@Context'
            {
             before(grammarAccess.getContextAnnotationAccess().getContextKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7479); 
             after(grammarAccess.getContextAnnotationAccess().getContextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__0__Impl"


    // $ANTLR start "rule__ContextAnnotation__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3697:1: rule__ContextAnnotation__Group__1 : rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 ;
    public final void rule__ContextAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3701:1: ( rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3702:2: rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17510);
            rule__ContextAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17513);
            rule__ContextAnnotation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__1"


    // $ANTLR start "rule__ContextAnnotation__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3709:1: rule__ContextAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__ContextAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3713:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3714:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3714:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3715:1: '('
            {
             before(grammarAccess.getContextAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7541); 
             after(grammarAccess.getContextAnnotationAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__1__Impl"


    // $ANTLR start "rule__ContextAnnotation__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3728:1: rule__ContextAnnotation__Group__2 : rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 ;
    public final void rule__ContextAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3732:1: ( rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3733:2: rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27572);
            rule__ContextAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27575);
            rule__ContextAnnotation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__2"


    // $ANTLR start "rule__ContextAnnotation__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3740:1: rule__ContextAnnotation__Group__2__Impl : ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) ;
    public final void rule__ContextAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3744:1: ( ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3745:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3745:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3746:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            {
             before(grammarAccess.getContextAnnotationAccess().getContextAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3747:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3747:2: rule__ContextAnnotation__ContextAssignment_2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7602);
            rule__ContextAnnotation__ContextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getContextAnnotationAccess().getContextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__2__Impl"


    // $ANTLR start "rule__ContextAnnotation__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3757:1: rule__ContextAnnotation__Group__3 : rule__ContextAnnotation__Group__3__Impl ;
    public final void rule__ContextAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3761:1: ( rule__ContextAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3762:2: rule__ContextAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37632);
            rule__ContextAnnotation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__3"


    // $ANTLR start "rule__ContextAnnotation__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3768:1: rule__ContextAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__ContextAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3772:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3773:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3773:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3774:1: ')'
            {
             before(grammarAccess.getContextAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7660); 
             after(grammarAccess.getContextAnnotationAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__Group__3__Impl"


    // $ANTLR start "rule__SamplingAnnotation__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3795:1: rule__SamplingAnnotation__Group__0 : rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 ;
    public final void rule__SamplingAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3799:1: ( rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3800:2: rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07699);
            rule__SamplingAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07702);
            rule__SamplingAnnotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__0"


    // $ANTLR start "rule__SamplingAnnotation__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3807:1: rule__SamplingAnnotation__Group__0__Impl : ( '@SamplingTime' ) ;
    public final void rule__SamplingAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3811:1: ( ( '@SamplingTime' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3812:1: ( '@SamplingTime' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3812:1: ( '@SamplingTime' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3813:1: '@SamplingTime'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingTimeKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7730); 
             after(grammarAccess.getSamplingAnnotationAccess().getSamplingTimeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__0__Impl"


    // $ANTLR start "rule__SamplingAnnotation__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3826:1: rule__SamplingAnnotation__Group__1 : rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 ;
    public final void rule__SamplingAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3830:1: ( rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3831:2: rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17761);
            rule__SamplingAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17764);
            rule__SamplingAnnotation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__1"


    // $ANTLR start "rule__SamplingAnnotation__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3838:1: rule__SamplingAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__SamplingAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3842:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3843:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3843:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3844:1: '('
            {
             before(grammarAccess.getSamplingAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7792); 
             after(grammarAccess.getSamplingAnnotationAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__1__Impl"


    // $ANTLR start "rule__SamplingAnnotation__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3857:1: rule__SamplingAnnotation__Group__2 : rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 ;
    public final void rule__SamplingAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3861:1: ( rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3862:2: rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27823);
            rule__SamplingAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27826);
            rule__SamplingAnnotation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__2"


    // $ANTLR start "rule__SamplingAnnotation__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3869:1: rule__SamplingAnnotation__Group__2__Impl : ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) ;
    public final void rule__SamplingAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3873:1: ( ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3874:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3874:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3875:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3876:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3876:2: rule__SamplingAnnotation__SamplingAssignment_2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7853);
            rule__SamplingAnnotation__SamplingAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSamplingAnnotationAccess().getSamplingAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__2__Impl"


    // $ANTLR start "rule__SamplingAnnotation__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3886:1: rule__SamplingAnnotation__Group__3 : rule__SamplingAnnotation__Group__3__Impl ;
    public final void rule__SamplingAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3890:1: ( rule__SamplingAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3891:2: rule__SamplingAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37883);
            rule__SamplingAnnotation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__3"


    // $ANTLR start "rule__SamplingAnnotation__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3897:1: rule__SamplingAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__SamplingAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3901:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3902:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3902:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3903:1: ')'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7911); 
             after(grammarAccess.getSamplingAnnotationAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__Group__3__Impl"


    // $ANTLR start "rule__PriorityAnnotation__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3924:1: rule__PriorityAnnotation__Group__0 : rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 ;
    public final void rule__PriorityAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3928:1: ( rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3929:2: rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__07950);
            rule__PriorityAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__07953);
            rule__PriorityAnnotation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__0"


    // $ANTLR start "rule__PriorityAnnotation__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3936:1: rule__PriorityAnnotation__Group__0__Impl : ( '@Priority' ) ;
    public final void rule__PriorityAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3940:1: ( ( '@Priority' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3941:1: ( '@Priority' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3941:1: ( '@Priority' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3942:1: '@Priority'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl7981); 
             after(grammarAccess.getPriorityAnnotationAccess().getPriorityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__0__Impl"


    // $ANTLR start "rule__PriorityAnnotation__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3955:1: rule__PriorityAnnotation__Group__1 : rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 ;
    public final void rule__PriorityAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3959:1: ( rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3960:2: rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__18012);
            rule__PriorityAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__18015);
            rule__PriorityAnnotation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__1"


    // $ANTLR start "rule__PriorityAnnotation__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3967:1: rule__PriorityAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__PriorityAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3971:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3972:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3972:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3973:1: '('
            {
             before(grammarAccess.getPriorityAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl8043); 
             after(grammarAccess.getPriorityAnnotationAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__1__Impl"


    // $ANTLR start "rule__PriorityAnnotation__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3986:1: rule__PriorityAnnotation__Group__2 : rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 ;
    public final void rule__PriorityAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3990:1: ( rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3991:2: rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__28074);
            rule__PriorityAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__28077);
            rule__PriorityAnnotation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__2"


    // $ANTLR start "rule__PriorityAnnotation__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3998:1: rule__PriorityAnnotation__Group__2__Impl : ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) ;
    public final void rule__PriorityAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4002:1: ( ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4003:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4003:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4004:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4005:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4005:2: rule__PriorityAnnotation__PriorityAssignment_2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl8104);
            rule__PriorityAnnotation__PriorityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPriorityAnnotationAccess().getPriorityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__2__Impl"


    // $ANTLR start "rule__PriorityAnnotation__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4015:1: rule__PriorityAnnotation__Group__3 : rule__PriorityAnnotation__Group__3__Impl ;
    public final void rule__PriorityAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4019:1: ( rule__PriorityAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4020:2: rule__PriorityAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__38134);
            rule__PriorityAnnotation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__3"


    // $ANTLR start "rule__PriorityAnnotation__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4026:1: rule__PriorityAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__PriorityAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4030:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4031:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4031:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4032:1: ')'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl8162); 
             after(grammarAccess.getPriorityAnnotationAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__Group__3__Impl"


    // $ANTLR start "rule__RangeFilter__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4053:1: rule__RangeFilter__Group__0 : rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 ;
    public final void rule__RangeFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4057:1: ( rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4058:2: rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__08201);
            rule__RangeFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__08204);
            rule__RangeFilter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__0"


    // $ANTLR start "rule__RangeFilter__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4065:1: rule__RangeFilter__Group__0__Impl : ( ( rule__RangeFilter__NegAssignment_0 )? ) ;
    public final void rule__RangeFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4069:1: ( ( ( rule__RangeFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4070:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4070:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4071:1: ( rule__RangeFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getRangeFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4072:1: ( rule__RangeFilter__NegAssignment_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==11) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4072:2: rule__RangeFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl8231);
                    rule__RangeFilter__NegAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRangeFilterAccess().getNegAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__0__Impl"


    // $ANTLR start "rule__RangeFilter__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4082:1: rule__RangeFilter__Group__1 : rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 ;
    public final void rule__RangeFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4086:1: ( rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4087:2: rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__18262);
            rule__RangeFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__18265);
            rule__RangeFilter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__1"


    // $ANTLR start "rule__RangeFilter__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4094:1: rule__RangeFilter__Group__1__Impl : ( 'in' ) ;
    public final void rule__RangeFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4098:1: ( ( 'in' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4099:1: ( 'in' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4099:1: ( 'in' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4100:1: 'in'
            {
             before(grammarAccess.getRangeFilterAccess().getInKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__RangeFilter__Group__1__Impl8293); 
             after(grammarAccess.getRangeFilterAccess().getInKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__1__Impl"


    // $ANTLR start "rule__RangeFilter__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4113:1: rule__RangeFilter__Group__2 : rule__RangeFilter__Group__2__Impl ;
    public final void rule__RangeFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4117:1: ( rule__RangeFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4118:2: rule__RangeFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__28324);
            rule__RangeFilter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__2"


    // $ANTLR start "rule__RangeFilter__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4124:1: rule__RangeFilter__Group__2__Impl : ( ( rule__RangeFilter__RangeAssignment_2 ) ) ;
    public final void rule__RangeFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4128:1: ( ( ( rule__RangeFilter__RangeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4129:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4129:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4130:1: ( rule__RangeFilter__RangeAssignment_2 )
            {
             before(grammarAccess.getRangeFilterAccess().getRangeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4131:1: ( rule__RangeFilter__RangeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4131:2: rule__RangeFilter__RangeAssignment_2
            {
            pushFollow(FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl8351);
            rule__RangeFilter__RangeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRangeFilterAccess().getRangeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__Group__2__Impl"


    // $ANTLR start "rule__OpenOpen__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4147:1: rule__OpenOpen__Group__0 : rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 ;
    public final void rule__OpenOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4151:1: ( rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4152:2: rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__08387);
            rule__OpenOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__08390);
            rule__OpenOpen__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__0"


    // $ANTLR start "rule__OpenOpen__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4159:1: rule__OpenOpen__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4163:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4164:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4164:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4165:1: '('
            {
             before(grammarAccess.getOpenOpenAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenOpen__Group__0__Impl8418); 
             after(grammarAccess.getOpenOpenAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__0__Impl"


    // $ANTLR start "rule__OpenOpen__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4178:1: rule__OpenOpen__Group__1 : rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 ;
    public final void rule__OpenOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4182:1: ( rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4183:2: rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__18449);
            rule__OpenOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__18452);
            rule__OpenOpen__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__1"


    // $ANTLR start "rule__OpenOpen__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4190:1: rule__OpenOpen__Group__1__Impl : ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4194:1: ( ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4195:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4195:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4196:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4197:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4197:2: rule__OpenOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8479);
            rule__OpenOpen__LowerBoundAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOpenOpenAccess().getLowerBoundAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__1__Impl"


    // $ANTLR start "rule__OpenOpen__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4207:1: rule__OpenOpen__Group__2 : rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 ;
    public final void rule__OpenOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4211:1: ( rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4212:2: rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28509);
            rule__OpenOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28512);
            rule__OpenOpen__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__2"


    // $ANTLR start "rule__OpenOpen__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4219:1: rule__OpenOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4223:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4224:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4224:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4225:1: ','
            {
             before(grammarAccess.getOpenOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8540); 
             after(grammarAccess.getOpenOpenAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__2__Impl"


    // $ANTLR start "rule__OpenOpen__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4238:1: rule__OpenOpen__Group__3 : rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 ;
    public final void rule__OpenOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4242:1: ( rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4243:2: rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38571);
            rule__OpenOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38574);
            rule__OpenOpen__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__3"


    // $ANTLR start "rule__OpenOpen__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4250:1: rule__OpenOpen__Group__3__Impl : ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4254:1: ( ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4255:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4255:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4256:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4257:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4257:2: rule__OpenOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8601);
            rule__OpenOpen__UpperBoundAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getOpenOpenAccess().getUpperBoundAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__3__Impl"


    // $ANTLR start "rule__OpenOpen__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4267:1: rule__OpenOpen__Group__4 : rule__OpenOpen__Group__4__Impl ;
    public final void rule__OpenOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4271:1: ( rule__OpenOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4272:2: rule__OpenOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48631);
            rule__OpenOpen__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__4"


    // $ANTLR start "rule__OpenOpen__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4278:1: rule__OpenOpen__Group__4__Impl : ( ')' ) ;
    public final void rule__OpenOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4282:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4283:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4283:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4284:1: ')'
            {
             before(grammarAccess.getOpenOpenAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8659); 
             after(grammarAccess.getOpenOpenAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__Group__4__Impl"


    // $ANTLR start "rule__OpenClosed__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4307:1: rule__OpenClosed__Group__0 : rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 ;
    public final void rule__OpenClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4311:1: ( rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4312:2: rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08700);
            rule__OpenClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08703);
            rule__OpenClosed__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__0"


    // $ANTLR start "rule__OpenClosed__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4319:1: rule__OpenClosed__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4323:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4324:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4324:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4325:1: '('
            {
             before(grammarAccess.getOpenClosedAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8731); 
             after(grammarAccess.getOpenClosedAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__0__Impl"


    // $ANTLR start "rule__OpenClosed__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4338:1: rule__OpenClosed__Group__1 : rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 ;
    public final void rule__OpenClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4342:1: ( rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4343:2: rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18762);
            rule__OpenClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18765);
            rule__OpenClosed__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__1"


    // $ANTLR start "rule__OpenClosed__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4350:1: rule__OpenClosed__Group__1__Impl : ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4354:1: ( ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4355:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4355:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4356:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4357:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4357:2: rule__OpenClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8792);
            rule__OpenClosed__LowerBoundAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOpenClosedAccess().getLowerBoundAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__1__Impl"


    // $ANTLR start "rule__OpenClosed__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4367:1: rule__OpenClosed__Group__2 : rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 ;
    public final void rule__OpenClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4371:1: ( rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4372:2: rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28822);
            rule__OpenClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28825);
            rule__OpenClosed__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__2"


    // $ANTLR start "rule__OpenClosed__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4379:1: rule__OpenClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4383:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4384:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4384:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4385:1: ','
            {
             before(grammarAccess.getOpenClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8853); 
             after(grammarAccess.getOpenClosedAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__2__Impl"


    // $ANTLR start "rule__OpenClosed__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4398:1: rule__OpenClosed__Group__3 : rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 ;
    public final void rule__OpenClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4402:1: ( rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4403:2: rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38884);
            rule__OpenClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38887);
            rule__OpenClosed__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__3"


    // $ANTLR start "rule__OpenClosed__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4410:1: rule__OpenClosed__Group__3__Impl : ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4414:1: ( ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4415:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4415:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4416:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4417:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4417:2: rule__OpenClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8914);
            rule__OpenClosed__UpperBoundAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getOpenClosedAccess().getUpperBoundAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__3__Impl"


    // $ANTLR start "rule__OpenClosed__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4427:1: rule__OpenClosed__Group__4 : rule__OpenClosed__Group__4__Impl ;
    public final void rule__OpenClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4431:1: ( rule__OpenClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4432:2: rule__OpenClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__48944);
            rule__OpenClosed__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__4"


    // $ANTLR start "rule__OpenClosed__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4438:1: rule__OpenClosed__Group__4__Impl : ( ']' ) ;
    public final void rule__OpenClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4442:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4443:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4443:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4444:1: ']'
            {
             before(grammarAccess.getOpenClosedAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__OpenClosed__Group__4__Impl8972); 
             after(grammarAccess.getOpenClosedAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__Group__4__Impl"


    // $ANTLR start "rule__ClosedClosed__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4467:1: rule__ClosedClosed__Group__0 : rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 ;
    public final void rule__ClosedClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4471:1: ( rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4472:2: rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__09013);
            rule__ClosedClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__09016);
            rule__ClosedClosed__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__0"


    // $ANTLR start "rule__ClosedClosed__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4479:1: rule__ClosedClosed__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4483:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4484:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4484:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4485:1: '['
            {
             before(grammarAccess.getClosedClosedAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl9044); 
             after(grammarAccess.getClosedClosedAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__0__Impl"


    // $ANTLR start "rule__ClosedClosed__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4498:1: rule__ClosedClosed__Group__1 : rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 ;
    public final void rule__ClosedClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4502:1: ( rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4503:2: rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__19075);
            rule__ClosedClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__19078);
            rule__ClosedClosed__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__1"


    // $ANTLR start "rule__ClosedClosed__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4510:1: rule__ClosedClosed__Group__1__Impl : ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4514:1: ( ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4515:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4515:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4516:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4517:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4517:2: rule__ClosedClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl9105);
            rule__ClosedClosed__LowerBoundAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClosedClosedAccess().getLowerBoundAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__1__Impl"


    // $ANTLR start "rule__ClosedClosed__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4527:1: rule__ClosedClosed__Group__2 : rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 ;
    public final void rule__ClosedClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4531:1: ( rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4532:2: rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__29135);
            rule__ClosedClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__29138);
            rule__ClosedClosed__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__2"


    // $ANTLR start "rule__ClosedClosed__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4539:1: rule__ClosedClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4543:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4544:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4544:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4545:1: ','
            {
             before(grammarAccess.getClosedClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl9166); 
             after(grammarAccess.getClosedClosedAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__2__Impl"


    // $ANTLR start "rule__ClosedClosed__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4558:1: rule__ClosedClosed__Group__3 : rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 ;
    public final void rule__ClosedClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4562:1: ( rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4563:2: rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__39197);
            rule__ClosedClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__39200);
            rule__ClosedClosed__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__3"


    // $ANTLR start "rule__ClosedClosed__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4570:1: rule__ClosedClosed__Group__3__Impl : ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4574:1: ( ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4575:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4575:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4576:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4577:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4577:2: rule__ClosedClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl9227);
            rule__ClosedClosed__UpperBoundAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getClosedClosedAccess().getUpperBoundAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__3__Impl"


    // $ANTLR start "rule__ClosedClosed__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4587:1: rule__ClosedClosed__Group__4 : rule__ClosedClosed__Group__4__Impl ;
    public final void rule__ClosedClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4591:1: ( rule__ClosedClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4592:2: rule__ClosedClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__49257);
            rule__ClosedClosed__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__4"


    // $ANTLR start "rule__ClosedClosed__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4598:1: rule__ClosedClosed__Group__4__Impl : ( ')' ) ;
    public final void rule__ClosedClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4602:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4603:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4603:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4604:1: ')'
            {
             before(grammarAccess.getClosedClosedAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl9285); 
             after(grammarAccess.getClosedClosedAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__Group__4__Impl"


    // $ANTLR start "rule__ClosedOpen__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4627:1: rule__ClosedOpen__Group__0 : rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 ;
    public final void rule__ClosedOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4631:1: ( rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4632:2: rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__09326);
            rule__ClosedOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__09329);
            rule__ClosedOpen__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__0"


    // $ANTLR start "rule__ClosedOpen__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4639:1: rule__ClosedOpen__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4643:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4644:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4644:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4645:1: '['
            {
             before(grammarAccess.getClosedOpenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl9357); 
             after(grammarAccess.getClosedOpenAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__0__Impl"


    // $ANTLR start "rule__ClosedOpen__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4658:1: rule__ClosedOpen__Group__1 : rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 ;
    public final void rule__ClosedOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4662:1: ( rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4663:2: rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__19388);
            rule__ClosedOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__19391);
            rule__ClosedOpen__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__1"


    // $ANTLR start "rule__ClosedOpen__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4670:1: rule__ClosedOpen__Group__1__Impl : ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4674:1: ( ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4675:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4675:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4676:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4677:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4677:2: rule__ClosedOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl9418);
            rule__ClosedOpen__LowerBoundAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClosedOpenAccess().getLowerBoundAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__1__Impl"


    // $ANTLR start "rule__ClosedOpen__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4687:1: rule__ClosedOpen__Group__2 : rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 ;
    public final void rule__ClosedOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4691:1: ( rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4692:2: rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__29448);
            rule__ClosedOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__29451);
            rule__ClosedOpen__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__2"


    // $ANTLR start "rule__ClosedOpen__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4699:1: rule__ClosedOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4703:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4704:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4704:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4705:1: ','
            {
             before(grammarAccess.getClosedOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9479); 
             after(grammarAccess.getClosedOpenAccess().getCommaKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__2__Impl"


    // $ANTLR start "rule__ClosedOpen__Group__3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4718:1: rule__ClosedOpen__Group__3 : rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 ;
    public final void rule__ClosedOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4722:1: ( rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4723:2: rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39510);
            rule__ClosedOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39513);
            rule__ClosedOpen__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__3"


    // $ANTLR start "rule__ClosedOpen__Group__3__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4730:1: rule__ClosedOpen__Group__3__Impl : ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4734:1: ( ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4735:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4735:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4736:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4737:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4737:2: rule__ClosedOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9540);
            rule__ClosedOpen__UpperBoundAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getClosedOpenAccess().getUpperBoundAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__3__Impl"


    // $ANTLR start "rule__ClosedOpen__Group__4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4747:1: rule__ClosedOpen__Group__4 : rule__ClosedOpen__Group__4__Impl ;
    public final void rule__ClosedOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4751:1: ( rule__ClosedOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4752:2: rule__ClosedOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49570);
            rule__ClosedOpen__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__4"


    // $ANTLR start "rule__ClosedOpen__Group__4__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4758:1: rule__ClosedOpen__Group__4__Impl : ( ']' ) ;
    public final void rule__ClosedOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4762:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4763:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4763:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4764:1: ']'
            {
             before(grammarAccess.getClosedOpenAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9598); 
             after(grammarAccess.getClosedOpenAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__Group__4__Impl"


    // $ANTLR start "rule__NumericFilter__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4787:1: rule__NumericFilter__Group__0 : rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 ;
    public final void rule__NumericFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4791:1: ( rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4792:2: rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09639);
            rule__NumericFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09642);
            rule__NumericFilter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__Group__0"


    // $ANTLR start "rule__NumericFilter__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4799:1: rule__NumericFilter__Group__0__Impl : ( ( rule__NumericFilter__OperatorAssignment_0 ) ) ;
    public final void rule__NumericFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4803:1: ( ( ( rule__NumericFilter__OperatorAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4804:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4804:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4805:1: ( rule__NumericFilter__OperatorAssignment_0 )
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4806:1: ( rule__NumericFilter__OperatorAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4806:2: rule__NumericFilter__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9669);
            rule__NumericFilter__OperatorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNumericFilterAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__Group__0__Impl"


    // $ANTLR start "rule__NumericFilter__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4816:1: rule__NumericFilter__Group__1 : rule__NumericFilter__Group__1__Impl ;
    public final void rule__NumericFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4820:1: ( rule__NumericFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4821:2: rule__NumericFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19699);
            rule__NumericFilter__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__Group__1"


    // $ANTLR start "rule__NumericFilter__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4827:1: rule__NumericFilter__Group__1__Impl : ( ( rule__NumericFilter__ValueAssignment_1 ) ) ;
    public final void rule__NumericFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4831:1: ( ( ( rule__NumericFilter__ValueAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4832:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4832:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4833:1: ( rule__NumericFilter__ValueAssignment_1 )
            {
             before(grammarAccess.getNumericFilterAccess().getValueAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4834:1: ( rule__NumericFilter__ValueAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4834:2: rule__NumericFilter__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9726);
            rule__NumericFilter__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNumericFilterAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__Group__1__Impl"


    // $ANTLR start "rule__LiteralFilter__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4848:1: rule__LiteralFilter__Group__0 : rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 ;
    public final void rule__LiteralFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4852:1: ( rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4853:2: rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09760);
            rule__LiteralFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09763);
            rule__LiteralFilter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__0"


    // $ANTLR start "rule__LiteralFilter__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4860:1: rule__LiteralFilter__Group__0__Impl : ( ( rule__LiteralFilter__NegAssignment_0 )? ) ;
    public final void rule__LiteralFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4864:1: ( ( ( rule__LiteralFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4865:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4865:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4866:1: ( rule__LiteralFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getLiteralFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4867:1: ( rule__LiteralFilter__NegAssignment_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==11) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4867:2: rule__LiteralFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9790);
                    rule__LiteralFilter__NegAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLiteralFilterAccess().getNegAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__0__Impl"


    // $ANTLR start "rule__LiteralFilter__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4877:1: rule__LiteralFilter__Group__1 : rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 ;
    public final void rule__LiteralFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4881:1: ( rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4882:2: rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19821);
            rule__LiteralFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19824);
            rule__LiteralFilter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__1"


    // $ANTLR start "rule__LiteralFilter__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4889:1: rule__LiteralFilter__Group__1__Impl : ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) ;
    public final void rule__LiteralFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4893:1: ( ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4894:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4894:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4895:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4896:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4896:2: rule__LiteralFilter__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9851);
            rule__LiteralFilter__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralFilterAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__1__Impl"


    // $ANTLR start "rule__LiteralFilter__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4906:1: rule__LiteralFilter__Group__2 : rule__LiteralFilter__Group__2__Impl ;
    public final void rule__LiteralFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4910:1: ( rule__LiteralFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4911:2: rule__LiteralFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29881);
            rule__LiteralFilter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__2"


    // $ANTLR start "rule__LiteralFilter__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4917:1: rule__LiteralFilter__Group__2__Impl : ( ( rule__LiteralFilter__ValueAssignment_2 ) ) ;
    public final void rule__LiteralFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4921:1: ( ( ( rule__LiteralFilter__ValueAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4922:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4922:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4923:1: ( rule__LiteralFilter__ValueAssignment_2 )
            {
             before(grammarAccess.getLiteralFilterAccess().getValueAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:1: ( rule__LiteralFilter__ValueAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:2: rule__LiteralFilter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9908);
            rule__LiteralFilter__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLiteralFilterAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__Group__2__Impl"


    // $ANTLR start "rule__FollowsExpression__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4940:1: rule__FollowsExpression__Group__0 : rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1 ;
    public final void rule__FollowsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4944:1: ( rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4945:2: rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__0__Impl_in_rule__FollowsExpression__Group__09944);
            rule__FollowsExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsExpression__Group__1_in_rule__FollowsExpression__Group__09947);
            rule__FollowsExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__Group__0"


    // $ANTLR start "rule__FollowsExpression__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4952:1: rule__FollowsExpression__Group__0__Impl : ( ( rule__FollowsExpression__FirstEventAssignment_0 ) ) ;
    public final void rule__FollowsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4956:1: ( ( ( rule__FollowsExpression__FirstEventAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4957:1: ( ( rule__FollowsExpression__FirstEventAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4957:1: ( ( rule__FollowsExpression__FirstEventAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4958:1: ( rule__FollowsExpression__FirstEventAssignment_0 )
            {
             before(grammarAccess.getFollowsExpressionAccess().getFirstEventAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4959:1: ( rule__FollowsExpression__FirstEventAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4959:2: rule__FollowsExpression__FirstEventAssignment_0
            {
            pushFollow(FOLLOW_rule__FollowsExpression__FirstEventAssignment_0_in_rule__FollowsExpression__Group__0__Impl9974);
            rule__FollowsExpression__FirstEventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFollowsExpressionAccess().getFirstEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__Group__0__Impl"


    // $ANTLR start "rule__FollowsExpression__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4969:1: rule__FollowsExpression__Group__1 : rule__FollowsExpression__Group__1__Impl ;
    public final void rule__FollowsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4973:1: ( rule__FollowsExpression__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4974:2: rule__FollowsExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__1__Impl_in_rule__FollowsExpression__Group__110004);
            rule__FollowsExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__Group__1"


    // $ANTLR start "rule__FollowsExpression__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4980:1: rule__FollowsExpression__Group__1__Impl : ( ( rule__FollowsExpression__EventsAssignment_1 )* ) ;
    public final void rule__FollowsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4984:1: ( ( ( rule__FollowsExpression__EventsAssignment_1 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4985:1: ( ( rule__FollowsExpression__EventsAssignment_1 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4985:1: ( ( rule__FollowsExpression__EventsAssignment_1 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4986:1: ( rule__FollowsExpression__EventsAssignment_1 )*
            {
             before(grammarAccess.getFollowsExpressionAccess().getEventsAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4987:1: ( rule__FollowsExpression__EventsAssignment_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=53 && LA25_0<=54)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4987:2: rule__FollowsExpression__EventsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__FollowsExpression__EventsAssignment_1_in_rule__FollowsExpression__Group__1__Impl10031);
            	    rule__FollowsExpression__EventsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getFollowsExpressionAccess().getEventsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__Group__1__Impl"


    // $ANTLR start "rule__EventWithFollowsOperator__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5001:1: rule__EventWithFollowsOperator__Group__0 : rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1 ;
    public final void rule__EventWithFollowsOperator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5005:1: ( rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5006:2: rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__0__Impl_in_rule__EventWithFollowsOperator__Group__010066);
            rule__EventWithFollowsOperator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__1_in_rule__EventWithFollowsOperator__Group__010069);
            rule__EventWithFollowsOperator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__Group__0"


    // $ANTLR start "rule__EventWithFollowsOperator__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5013:1: rule__EventWithFollowsOperator__Group__0__Impl : ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) ) ;
    public final void rule__EventWithFollowsOperator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5017:1: ( ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5018:1: ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5018:1: ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5019:1: ( rule__EventWithFollowsOperator__OperatorAssignment_0 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5020:1: ( rule__EventWithFollowsOperator__OperatorAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5020:2: rule__EventWithFollowsOperator__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__OperatorAssignment_0_in_rule__EventWithFollowsOperator__Group__0__Impl10096);
            rule__EventWithFollowsOperator__OperatorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__Group__0__Impl"


    // $ANTLR start "rule__EventWithFollowsOperator__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5030:1: rule__EventWithFollowsOperator__Group__1 : rule__EventWithFollowsOperator__Group__1__Impl ;
    public final void rule__EventWithFollowsOperator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5034:1: ( rule__EventWithFollowsOperator__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5035:2: rule__EventWithFollowsOperator__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__1__Impl_in_rule__EventWithFollowsOperator__Group__110126);
            rule__EventWithFollowsOperator__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__Group__1"


    // $ANTLR start "rule__EventWithFollowsOperator__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5041:1: rule__EventWithFollowsOperator__Group__1__Impl : ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) ) ;
    public final void rule__EventWithFollowsOperator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5045:1: ( ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5046:1: ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5046:1: ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5047:1: ( rule__EventWithFollowsOperator__EventAssignment_1 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getEventAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5048:1: ( rule__EventWithFollowsOperator__EventAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5048:2: rule__EventWithFollowsOperator__EventAssignment_1
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__EventAssignment_1_in_rule__EventWithFollowsOperator__Group__1__Impl10153);
            rule__EventWithFollowsOperator__EventAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEventWithFollowsOperatorAccess().getEventAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__Group__1__Impl"


    // $ANTLR start "rule__FollowsOperatorNoTW__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5062:1: rule__FollowsOperatorNoTW__Group__0 : rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1 ;
    public final void rule__FollowsOperatorNoTW__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5066:1: ( rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5067:2: rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__0__Impl_in_rule__FollowsOperatorNoTW__Group__010187);
            rule__FollowsOperatorNoTW__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__1_in_rule__FollowsOperatorNoTW__Group__010190);
            rule__FollowsOperatorNoTW__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorNoTW__Group__0"


    // $ANTLR start "rule__FollowsOperatorNoTW__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5074:1: rule__FollowsOperatorNoTW__Group__0__Impl : ( () ) ;
    public final void rule__FollowsOperatorNoTW__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5078:1: ( ( () ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5079:1: ( () )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5079:1: ( () )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5080:1: ()
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getFollowsOperatorNoTWAction_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5081:1: ()
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5083:1: 
            {
            }

             after(grammarAccess.getFollowsOperatorNoTWAccess().getFollowsOperatorNoTWAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorNoTW__Group__0__Impl"


    // $ANTLR start "rule__FollowsOperatorNoTW__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5093:1: rule__FollowsOperatorNoTW__Group__1 : rule__FollowsOperatorNoTW__Group__1__Impl ;
    public final void rule__FollowsOperatorNoTW__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5097:1: ( rule__FollowsOperatorNoTW__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5098:2: rule__FollowsOperatorNoTW__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__1__Impl_in_rule__FollowsOperatorNoTW__Group__110248);
            rule__FollowsOperatorNoTW__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorNoTW__Group__1"


    // $ANTLR start "rule__FollowsOperatorNoTW__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5104:1: rule__FollowsOperatorNoTW__Group__1__Impl : ( '->' ) ;
    public final void rule__FollowsOperatorNoTW__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5108:1: ( ( '->' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5109:1: ( '->' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5109:1: ( '->' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5110:1: '->'
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__FollowsOperatorNoTW__Group__1__Impl10276); 
             after(grammarAccess.getFollowsOperatorNoTWAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorNoTW__Group__1__Impl"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5127:1: rule__FollowsOperatorViaTW__Group__0 : rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1 ;
    public final void rule__FollowsOperatorViaTW__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5131:1: ( rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5132:2: rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__0__Impl_in_rule__FollowsOperatorViaTW__Group__010311);
            rule__FollowsOperatorViaTW__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__1_in_rule__FollowsOperatorViaTW__Group__010314);
            rule__FollowsOperatorViaTW__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__0"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5139:1: rule__FollowsOperatorViaTW__Group__0__Impl : ( '-[' ) ;
    public final void rule__FollowsOperatorViaTW__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5143:1: ( ( '-[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5144:1: ( '-[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5144:1: ( '-[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5145:1: '-['
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getHyphenMinusLeftSquareBracketKeyword_0()); 
            match(input,54,FOLLOW_54_in_rule__FollowsOperatorViaTW__Group__0__Impl10342); 
             after(grammarAccess.getFollowsOperatorViaTWAccess().getHyphenMinusLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__0__Impl"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5158:1: rule__FollowsOperatorViaTW__Group__1 : rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2 ;
    public final void rule__FollowsOperatorViaTW__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5162:1: ( rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5163:2: rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__1__Impl_in_rule__FollowsOperatorViaTW__Group__110373);
            rule__FollowsOperatorViaTW__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__2_in_rule__FollowsOperatorViaTW__Group__110376);
            rule__FollowsOperatorViaTW__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__1"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5170:1: rule__FollowsOperatorViaTW__Group__1__Impl : ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) ) ;
    public final void rule__FollowsOperatorViaTW__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5174:1: ( ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5175:1: ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5175:1: ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5176:1: ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 )
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5177:1: ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5177:2: rule__FollowsOperatorViaTW__TimewindowAssignment_1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__TimewindowAssignment_1_in_rule__FollowsOperatorViaTW__Group__1__Impl10403);
            rule__FollowsOperatorViaTW__TimewindowAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__1__Impl"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5187:1: rule__FollowsOperatorViaTW__Group__2 : rule__FollowsOperatorViaTW__Group__2__Impl ;
    public final void rule__FollowsOperatorViaTW__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5191:1: ( rule__FollowsOperatorViaTW__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5192:2: rule__FollowsOperatorViaTW__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__2__Impl_in_rule__FollowsOperatorViaTW__Group__210433);
            rule__FollowsOperatorViaTW__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__2"


    // $ANTLR start "rule__FollowsOperatorViaTW__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5198:1: rule__FollowsOperatorViaTW__Group__2__Impl : ( ']->' ) ;
    public final void rule__FollowsOperatorViaTW__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5202:1: ( ( ']->' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5203:1: ( ']->' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5203:1: ( ']->' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5204:1: ']->'
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,55,FOLLOW_55_in_rule__FollowsOperatorViaTW__Group__2__Impl10461); 
             after(grammarAccess.getFollowsOperatorViaTWAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__Group__2__Impl"


    // $ANTLR start "rule__EventWithMultiplicity__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5223:1: rule__EventWithMultiplicity__Group__0 : rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1 ;
    public final void rule__EventWithMultiplicity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5227:1: ( rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5228:2: rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__0__Impl_in_rule__EventWithMultiplicity__Group__010498);
            rule__EventWithMultiplicity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__1_in_rule__EventWithMultiplicity__Group__010501);
            rule__EventWithMultiplicity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group__0"


    // $ANTLR start "rule__EventWithMultiplicity__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5235:1: rule__EventWithMultiplicity__Group__0__Impl : ( ( rule__EventWithMultiplicity__EventAssignment_0 ) ) ;
    public final void rule__EventWithMultiplicity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5239:1: ( ( ( rule__EventWithMultiplicity__EventAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5240:1: ( ( rule__EventWithMultiplicity__EventAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5240:1: ( ( rule__EventWithMultiplicity__EventAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5241:1: ( rule__EventWithMultiplicity__EventAssignment_0 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5242:1: ( rule__EventWithMultiplicity__EventAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5242:2: rule__EventWithMultiplicity__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__EventAssignment_0_in_rule__EventWithMultiplicity__Group__0__Impl10528);
            rule__EventWithMultiplicity__EventAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEventWithMultiplicityAccess().getEventAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group__0__Impl"


    // $ANTLR start "rule__EventWithMultiplicity__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5252:1: rule__EventWithMultiplicity__Group__1 : rule__EventWithMultiplicity__Group__1__Impl ;
    public final void rule__EventWithMultiplicity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5256:1: ( rule__EventWithMultiplicity__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5257:2: rule__EventWithMultiplicity__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__1__Impl_in_rule__EventWithMultiplicity__Group__110558);
            rule__EventWithMultiplicity__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group__1"


    // $ANTLR start "rule__EventWithMultiplicity__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5263:1: rule__EventWithMultiplicity__Group__1__Impl : ( ( rule__EventWithMultiplicity__Group_1__0 )? ) ;
    public final void rule__EventWithMultiplicity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5267:1: ( ( ( rule__EventWithMultiplicity__Group_1__0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5268:1: ( ( rule__EventWithMultiplicity__Group_1__0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5268:1: ( ( rule__EventWithMultiplicity__Group_1__0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5269:1: ( rule__EventWithMultiplicity__Group_1__0 )?
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5270:1: ( rule__EventWithMultiplicity__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5270:2: rule__EventWithMultiplicity__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__0_in_rule__EventWithMultiplicity__Group__1__Impl10585);
                    rule__EventWithMultiplicity__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEventWithMultiplicityAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group__1__Impl"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5284:1: rule__EventWithMultiplicity__Group_1__0 : rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1 ;
    public final void rule__EventWithMultiplicity__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5288:1: ( rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5289:2: rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__0__Impl_in_rule__EventWithMultiplicity__Group_1__010620);
            rule__EventWithMultiplicity__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__1_in_rule__EventWithMultiplicity__Group_1__010623);
            rule__EventWithMultiplicity__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__0"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5296:1: rule__EventWithMultiplicity__Group_1__0__Impl : ( '{' ) ;
    public final void rule__EventWithMultiplicity__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5300:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5301:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5301:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5302:1: '{'
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__EventWithMultiplicity__Group_1__0__Impl10651); 
             after(grammarAccess.getEventWithMultiplicityAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__0__Impl"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5315:1: rule__EventWithMultiplicity__Group_1__1 : rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2 ;
    public final void rule__EventWithMultiplicity__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5319:1: ( rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5320:2: rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__1__Impl_in_rule__EventWithMultiplicity__Group_1__110682);
            rule__EventWithMultiplicity__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__2_in_rule__EventWithMultiplicity__Group_1__110685);
            rule__EventWithMultiplicity__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__1"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5327:1: rule__EventWithMultiplicity__Group_1__1__Impl : ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) ) ;
    public final void rule__EventWithMultiplicity__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5331:1: ( ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5332:1: ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5332:1: ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5333:1: ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityAssignment_1_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5334:1: ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5334:2: rule__EventWithMultiplicity__MultiplicityAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__MultiplicityAssignment_1_1_in_rule__EventWithMultiplicity__Group_1__1__Impl10712);
            rule__EventWithMultiplicity__MultiplicityAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__1__Impl"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5344:1: rule__EventWithMultiplicity__Group_1__2 : rule__EventWithMultiplicity__Group_1__2__Impl ;
    public final void rule__EventWithMultiplicity__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5348:1: ( rule__EventWithMultiplicity__Group_1__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5349:2: rule__EventWithMultiplicity__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__2__Impl_in_rule__EventWithMultiplicity__Group_1__210742);
            rule__EventWithMultiplicity__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__2"


    // $ANTLR start "rule__EventWithMultiplicity__Group_1__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5355:1: rule__EventWithMultiplicity__Group_1__2__Impl : ( '}' ) ;
    public final void rule__EventWithMultiplicity__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5359:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5360:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5360:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5361:1: '}'
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,33,FOLLOW_33_in_rule__EventWithMultiplicity__Group_1__2__Impl10770); 
             after(grammarAccess.getEventWithMultiplicityAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__Group_1__2__Impl"


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5381:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5385:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5386:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5386:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5387:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_110812);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__UsagesAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5396:1: rule__PackageDeclaration__UsagesAssignment_2 : ( ruleUsage ) ;
    public final void rule__PackageDeclaration__UsagesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5400:1: ( ( ruleUsage ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5401:1: ( ruleUsage )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5401:1: ( ruleUsage )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5402:1: ruleUsage
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesUsageParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_210843);
            ruleUsage();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getUsagesUsageParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__UsagesAssignment_2"


    // $ANTLR start "rule__PackageDeclaration__ModelAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5411:1: rule__PackageDeclaration__ModelAssignment_3 : ( ruleModel ) ;
    public final void rule__PackageDeclaration__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5415:1: ( ( ruleModel ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5416:1: ( ruleModel )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5416:1: ( ruleModel )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5417:1: ruleModel
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelModelParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_310874);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getModelModelParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__ModelAssignment_3"


    // $ANTLR start "rule__IQUsage__ImportedNamespaceAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5426:1: rule__IQUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__IQUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5430:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5431:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5431:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5432:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_110905);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQUsage__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__EventSourceUsage__ImportedNamespaceAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5441:1: rule__EventSourceUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__EventSourceUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5445:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5446:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5446:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5447:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_110936);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventSourceUsage__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Model__AnnotationsAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5456:1: rule__Model__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__Model__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5460:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5461:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5461:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5462:1: ruleAnnotations
            {
             before(grammarAccess.getModelAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_010967);
            ruleAnnotations();

            state._fsp--;

             after(grammarAccess.getModelAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__AnnotationsAssignment_0"


    // $ANTLR start "rule__Model__NameAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5471:1: rule__Model__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5475:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5476:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5476:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5477:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_210998); 
             after(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_2"


    // $ANTLR start "rule__Model__EventsAssignment_4"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5486:1: rule__Model__EventsAssignment_4 : ( ruleEvent ) ;
    public final void rule__Model__EventsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5490:1: ( ( ruleEvent ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5491:1: ( ruleEvent )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5491:1: ( ruleEvent )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5492:1: ruleEvent
            {
             before(grammarAccess.getModelAccess().getEventsEventParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_411029);
            ruleEvent();

            state._fsp--;

             after(grammarAccess.getModelAccess().getEventsEventParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__EventsAssignment_4"


    // $ANTLR start "rule__AtomicEvent__AnnotationsAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5501:1: rule__AtomicEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__AtomicEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5505:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5506:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5506:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5507:1: ruleAnnotations
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_011060);
            ruleAnnotations();

            state._fsp--;

             after(grammarAccess.getAtomicEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__AnnotationsAssignment_0"


    // $ANTLR start "rule__AtomicEvent__NameAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5516:1: rule__AtomicEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__AtomicEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5520:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5521:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5521:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5522:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_211091); 
             after(grammarAccess.getAtomicEventAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__NameAssignment_2"


    // $ANTLR start "rule__AtomicEvent__IdAssignment_7"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5531:1: rule__AtomicEvent__IdAssignment_7 : ( RULE_STRING ) ;
    public final void rule__AtomicEvent__IdAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5535:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5536:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5536:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5537:1: RULE_STRING
            {
             before(grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_7_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_711122); 
             after(grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__IdAssignment_7"


    // $ANTLR start "rule__AtomicEvent__SourceAssignment_10"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5546:1: rule__AtomicEvent__SourceAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__AtomicEvent__SourceAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5550:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5551:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5551:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5552:1: ( RULE_ID )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_10_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5553:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5554:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_1011157); 
             after(grammarAccess.getAtomicEventAccess().getSourceSourceIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__SourceAssignment_10"


    // $ANTLR start "rule__AtomicEvent__ParameterFiltersAssignment_13"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5565:1: rule__AtomicEvent__ParameterFiltersAssignment_13 : ( ruleParameterFilter ) ;
    public final void rule__AtomicEvent__ParameterFiltersAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5569:1: ( ( ruleParameterFilter ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5570:1: ( ruleParameterFilter )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5570:1: ( ruleParameterFilter )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5571:1: ruleParameterFilter
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersParameterFilterParserRuleCall_13_0()); 
            pushFollow(FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_1311192);
            ruleParameterFilter();

            state._fsp--;

             after(grammarAccess.getAtomicEventAccess().getParameterFiltersParameterFilterParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AtomicEvent__ParameterFiltersAssignment_13"


    // $ANTLR start "rule__IQPatternEvent__NameAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5580:1: rule__IQPatternEvent__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IQPatternEvent__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5584:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5585:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5585:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5586:1: RULE_ID
            {
             before(grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_111223); 
             after(grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__NameAssignment_1"


    // $ANTLR start "rule__IQPatternEvent__IqpatternAssignment_6"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5595:1: rule__IQPatternEvent__IqpatternAssignment_6 : ( RULE_STRING ) ;
    public final void rule__IQPatternEvent__IqpatternAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5599:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5600:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5600:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5601:1: RULE_STRING
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__IQPatternEvent__IqpatternAssignment_611254); 
             after(grammarAccess.getIQPatternEventAccess().getIqpatternSTRINGTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__IqpatternAssignment_6"


    // $ANTLR start "rule__IQPatternEvent__ChangeTypeAssignment_9"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5610:1: rule__IQPatternEvent__ChangeTypeAssignment_9 : ( ruleIQPatternChangeType ) ;
    public final void rule__IQPatternEvent__ChangeTypeAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5614:1: ( ( ruleIQPatternChangeType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5615:1: ( ruleIQPatternChangeType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5615:1: ( ruleIQPatternChangeType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5616:1: ruleIQPatternChangeType
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_911285);
            ruleIQPatternChangeType();

            state._fsp--;

             after(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IQPatternEvent__ChangeTypeAssignment_9"


    // $ANTLR start "rule__ComplexEvent__AnnotationsAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5625:1: rule__ComplexEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__ComplexEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5629:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5630:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5630:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5631:1: ruleAnnotations
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_011316);
            ruleAnnotations();

            state._fsp--;

             after(grammarAccess.getComplexEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__AnnotationsAssignment_0"


    // $ANTLR start "rule__ComplexEvent__NameAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5640:1: rule__ComplexEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComplexEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5644:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5645:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5645:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5646:1: RULE_ID
            {
             before(grammarAccess.getComplexEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_211347); 
             after(grammarAccess.getComplexEventAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__NameAssignment_2"


    // $ANTLR start "rule__ComplexEvent__ParamlistAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5655:1: rule__ComplexEvent__ParamlistAssignment_3 : ( ruleCEParamlist ) ;
    public final void rule__ComplexEvent__ParamlistAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5659:1: ( ( ruleCEParamlist ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5660:1: ( ruleCEParamlist )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5660:1: ( ruleCEParamlist )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5661:1: ruleCEParamlist
            {
             before(grammarAccess.getComplexEventAccess().getParamlistCEParamlistParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_311378);
            ruleCEParamlist();

            state._fsp--;

             after(grammarAccess.getComplexEventAccess().getParamlistCEParamlistParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__ParamlistAssignment_3"


    // $ANTLR start "rule__ComplexEvent__ComplexEventExpressionsAssignment_5"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5670:1: rule__ComplexEvent__ComplexEventExpressionsAssignment_5 : ( ruleComplexEventExpression ) ;
    public final void rule__ComplexEvent__ComplexEventExpressionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5674:1: ( ( ruleComplexEventExpression ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5675:1: ( ruleComplexEventExpression )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5675:1: ( ruleComplexEventExpression )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5676:1: ruleComplexEventExpression
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventExpressionsComplexEventExpressionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleComplexEventExpression_in_rule__ComplexEvent__ComplexEventExpressionsAssignment_511409);
            ruleComplexEventExpression();

            state._fsp--;

             after(grammarAccess.getComplexEventAccess().getComplexEventExpressionsComplexEventExpressionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEvent__ComplexEventExpressionsAssignment_5"


    // $ANTLR start "rule__CEParamlist__ParamsAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5685:1: rule__CEParamlist__ParamsAssignment_2 : ( ruleEventParamWithType ) ;
    public final void rule__CEParamlist__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5689:1: ( ( ruleEventParamWithType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5690:1: ( ruleEventParamWithType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5690:1: ( ruleEventParamWithType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5691:1: ruleEventParamWithType
            {
             before(grammarAccess.getCEParamlistAccess().getParamsEventParamWithTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEventParamWithType_in_rule__CEParamlist__ParamsAssignment_211440);
            ruleEventParamWithType();

            state._fsp--;

             after(grammarAccess.getCEParamlistAccess().getParamsEventParamWithTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CEParamlist__ParamsAssignment_2"


    // $ANTLR start "rule__EventParamWithType__NameAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5700:1: rule__EventParamWithType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EventParamWithType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5704:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5705:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5705:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5706:1: RULE_ID
            {
             before(grammarAccess.getEventParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventParamWithType__NameAssignment_011471); 
             after(grammarAccess.getEventParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__NameAssignment_0"


    // $ANTLR start "rule__EventParamWithType__TypeAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5715:1: rule__EventParamWithType__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EventParamWithType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5719:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5720:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5720:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5721:1: ( RULE_ID )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeEventCrossReference_2_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5722:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5723:1: RULE_ID
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeEventIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventParamWithType__TypeAssignment_211506); 
             after(grammarAccess.getEventParamWithTypeAccess().getTypeEventIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEventParamWithTypeAccess().getTypeEventCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventParamWithType__TypeAssignment_2"


    // $ANTLR start "rule__ParameterFilter__AttributeNameAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5734:1: rule__ParameterFilter__AttributeNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterFilter__AttributeNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5738:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5739:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5739:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5740:1: RULE_ID
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_011541); 
             after(grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__AttributeNameAssignment_0"


    // $ANTLR start "rule__ParameterFilter__ParamFilterRuleAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5749:1: rule__ParameterFilter__ParamFilterRuleAssignment_1 : ( ruleParameterFilterRule ) ;
    public final void rule__ParameterFilter__ParamFilterRuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5753:1: ( ( ruleParameterFilterRule ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5754:1: ( ruleParameterFilterRule )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5754:1: ( ruleParameterFilterRule )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5755:1: ruleParameterFilterRule
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_111572);
            ruleParameterFilterRule();

            state._fsp--;

             after(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterFilter__ParamFilterRuleAssignment_1"


    // $ANTLR start "rule__ContextAnnotation__ContextAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5764:1: rule__ContextAnnotation__ContextAssignment_2 : ( ruleContext ) ;
    public final void rule__ContextAnnotation__ContextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5768:1: ( ( ruleContext ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5769:1: ( ruleContext )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5769:1: ( ruleContext )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5770:1: ruleContext
            {
             before(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_211603);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextAnnotation__ContextAssignment_2"


    // $ANTLR start "rule__SamplingAnnotation__SamplingAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5779:1: rule__SamplingAnnotation__SamplingAssignment_2 : ( RULE_INT ) ;
    public final void rule__SamplingAnnotation__SamplingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5783:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5784:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5784:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5785:1: RULE_INT
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_211634); 
             after(grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SamplingAnnotation__SamplingAssignment_2"


    // $ANTLR start "rule__PriorityAnnotation__PriorityAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5794:1: rule__PriorityAnnotation__PriorityAssignment_2 : ( RULE_INT ) ;
    public final void rule__PriorityAnnotation__PriorityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5798:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5799:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5799:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5800:1: RULE_INT
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_211665); 
             after(grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PriorityAnnotation__PriorityAssignment_2"


    // $ANTLR start "rule__RangeFilter__NegAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5809:1: rule__RangeFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__RangeFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5813:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5814:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5814:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5815:1: ruleNegationOpartor
            {
             before(grammarAccess.getRangeFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_011696);
            ruleNegationOpartor();

            state._fsp--;

             after(grammarAccess.getRangeFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__NegAssignment_0"


    // $ANTLR start "rule__RangeFilter__RangeAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5824:1: rule__RangeFilter__RangeAssignment_2 : ( ruleRange ) ;
    public final void rule__RangeFilter__RangeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5828:1: ( ( ruleRange ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5829:1: ( ruleRange )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5829:1: ( ruleRange )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5830:1: ruleRange
            {
             before(grammarAccess.getRangeFilterAccess().getRangeRangeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_211727);
            ruleRange();

            state._fsp--;

             after(grammarAccess.getRangeFilterAccess().getRangeRangeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeFilter__RangeAssignment_2"


    // $ANTLR start "rule__OpenOpen__LowerBoundAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5839:1: rule__OpenOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5843:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5844:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5844:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5845:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_111758);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__LowerBoundAssignment_1"


    // $ANTLR start "rule__OpenOpen__UpperBoundAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5854:1: rule__OpenOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5858:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5859:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5859:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5860:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_311789);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenOpen__UpperBoundAssignment_3"


    // $ANTLR start "rule__OpenClosed__LowerBoundAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5869:1: rule__OpenClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5873:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5874:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5874:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5875:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_111820);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__LowerBoundAssignment_1"


    // $ANTLR start "rule__OpenClosed__UpperBoundAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5884:1: rule__OpenClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5888:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5889:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5889:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5890:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_311851);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OpenClosed__UpperBoundAssignment_3"


    // $ANTLR start "rule__ClosedClosed__LowerBoundAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5899:1: rule__ClosedClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5903:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5904:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5904:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5905:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_111882);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__LowerBoundAssignment_1"


    // $ANTLR start "rule__ClosedClosed__UpperBoundAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5914:1: rule__ClosedClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5918:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5919:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5919:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5920:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_311913);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedClosed__UpperBoundAssignment_3"


    // $ANTLR start "rule__ClosedOpen__LowerBoundAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5929:1: rule__ClosedOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5933:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5934:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5934:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5935:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_111944);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__LowerBoundAssignment_1"


    // $ANTLR start "rule__ClosedOpen__UpperBoundAssignment_3"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5944:1: rule__ClosedOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5948:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5949:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5949:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5950:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_311975);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClosedOpen__UpperBoundAssignment_3"


    // $ANTLR start "rule__NumericFilter__OperatorAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5959:1: rule__NumericFilter__OperatorAssignment_0 : ( ruleNumericOperator ) ;
    public final void rule__NumericFilter__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5963:1: ( ( ruleNumericOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5964:1: ( ruleNumericOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5964:1: ( ruleNumericOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5965:1: ruleNumericOperator
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_012006);
            ruleNumericOperator();

            state._fsp--;

             after(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__OperatorAssignment_0"


    // $ANTLR start "rule__NumericFilter__ValueAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5974:1: rule__NumericFilter__ValueAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__NumericFilter__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5978:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5979:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5979:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5980:1: ruleDOUBLE
            {
             before(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_112037);
            ruleDOUBLE();

            state._fsp--;

             after(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumericFilter__ValueAssignment_1"


    // $ANTLR start "rule__LiteralFilter__NegAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5989:1: rule__LiteralFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__LiteralFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5993:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5994:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5994:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5995:1: ruleNegationOpartor
            {
             before(grammarAccess.getLiteralFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_012068);
            ruleNegationOpartor();

            state._fsp--;

             after(grammarAccess.getLiteralFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__NegAssignment_0"


    // $ANTLR start "rule__LiteralFilter__OperatorAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6004:1: rule__LiteralFilter__OperatorAssignment_1 : ( ruleLiteralOperator ) ;
    public final void rule__LiteralFilter__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6008:1: ( ( ruleLiteralOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6009:1: ( ruleLiteralOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6009:1: ( ruleLiteralOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6010:1: ruleLiteralOperator
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorLiteralOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_112099);
            ruleLiteralOperator();

            state._fsp--;

             after(grammarAccess.getLiteralFilterAccess().getOperatorLiteralOperatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__OperatorAssignment_1"


    // $ANTLR start "rule__LiteralFilter__ValueAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6019:1: rule__LiteralFilter__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LiteralFilter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6023:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6024:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6024:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6025:1: RULE_STRING
            {
             before(grammarAccess.getLiteralFilterAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_212130); 
             after(grammarAccess.getLiteralFilterAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralFilter__ValueAssignment_2"


    // $ANTLR start "rule__FollowsExpression__FirstEventAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6034:1: rule__FollowsExpression__FirstEventAssignment_0 : ( ruleEventWithMultiplicity ) ;
    public final void rule__FollowsExpression__FirstEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6038:1: ( ( ruleEventWithMultiplicity ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6039:1: ( ruleEventWithMultiplicity )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6039:1: ( ruleEventWithMultiplicity )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6040:1: ruleEventWithMultiplicity
            {
             before(grammarAccess.getFollowsExpressionAccess().getFirstEventEventWithMultiplicityParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_rule__FollowsExpression__FirstEventAssignment_012161);
            ruleEventWithMultiplicity();

            state._fsp--;

             after(grammarAccess.getFollowsExpressionAccess().getFirstEventEventWithMultiplicityParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__FirstEventAssignment_0"


    // $ANTLR start "rule__FollowsExpression__EventsAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6049:1: rule__FollowsExpression__EventsAssignment_1 : ( ruleEventWithFollowsOperator ) ;
    public final void rule__FollowsExpression__EventsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6053:1: ( ( ruleEventWithFollowsOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6054:1: ( ruleEventWithFollowsOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6054:1: ( ruleEventWithFollowsOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6055:1: ruleEventWithFollowsOperator
            {
             before(grammarAccess.getFollowsExpressionAccess().getEventsEventWithFollowsOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEventWithFollowsOperator_in_rule__FollowsExpression__EventsAssignment_112192);
            ruleEventWithFollowsOperator();

            state._fsp--;

             after(grammarAccess.getFollowsExpressionAccess().getEventsEventWithFollowsOperatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsExpression__EventsAssignment_1"


    // $ANTLR start "rule__EventWithFollowsOperator__OperatorAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6064:1: rule__EventWithFollowsOperator__OperatorAssignment_0 : ( ruleFollowsOperator ) ;
    public final void rule__EventWithFollowsOperator__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6068:1: ( ( ruleFollowsOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6069:1: ( ruleFollowsOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6069:1: ( ruleFollowsOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6070:1: ruleFollowsOperator
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorFollowsOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFollowsOperator_in_rule__EventWithFollowsOperator__OperatorAssignment_012223);
            ruleFollowsOperator();

            state._fsp--;

             after(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorFollowsOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__OperatorAssignment_0"


    // $ANTLR start "rule__EventWithFollowsOperator__EventAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6079:1: rule__EventWithFollowsOperator__EventAssignment_1 : ( ruleEventWithMultiplicity ) ;
    public final void rule__EventWithFollowsOperator__EventAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6083:1: ( ( ruleEventWithMultiplicity ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6084:1: ( ruleEventWithMultiplicity )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6084:1: ( ruleEventWithMultiplicity )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6085:1: ruleEventWithMultiplicity
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getEventEventWithMultiplicityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_rule__EventWithFollowsOperator__EventAssignment_112254);
            ruleEventWithMultiplicity();

            state._fsp--;

             after(grammarAccess.getEventWithFollowsOperatorAccess().getEventEventWithMultiplicityParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithFollowsOperator__EventAssignment_1"


    // $ANTLR start "rule__FollowsOperatorViaTW__TimewindowAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6094:1: rule__FollowsOperatorViaTW__TimewindowAssignment_1 : ( RULE_INT ) ;
    public final void rule__FollowsOperatorViaTW__TimewindowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6098:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6099:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6099:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6100:1: RULE_INT
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FollowsOperatorViaTW__TimewindowAssignment_112285); 
             after(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FollowsOperatorViaTW__TimewindowAssignment_1"


    // $ANTLR start "rule__EventWithMultiplicity__EventAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6109:1: rule__EventWithMultiplicity__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EventWithMultiplicity__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6113:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6114:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6114:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6115:1: ( RULE_ID )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeCrossReference_0_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6116:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6117:1: RULE_ID
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventWithMultiplicity__EventAssignment_012320); 
             after(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__EventAssignment_0"


    // $ANTLR start "rule__EventWithMultiplicity__MultiplicityAssignment_1_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6128:1: rule__EventWithMultiplicity__MultiplicityAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__EventWithMultiplicity__MultiplicityAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6132:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6133:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6133:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6134:1: RULE_INT
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EventWithMultiplicity__MultiplicityAssignment_1_112355); 
             after(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityINTTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EventWithMultiplicity__MultiplicityAssignment_1_1"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA2_eotS =
        "\21\uffff";
    static final String DFA2_eofS =
        "\21\uffff";
    static final String DFA2_minS =
        "\1\42\3\54\2\uffff\1\27\2\4\5\55\3\42";
    static final String DFA2_maxS =
        "\1\60\3\54\2\uffff\1\31\2\4\5\55\3\60";
    static final String DFA2_acceptS =
        "\4\uffff\1\1\1\2\13\uffff";
    static final String DFA2_specialS =
        "\21\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\4\5\uffff\1\4\2\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\6",
            "\1\7",
            "\1\10",
            "",
            "",
            "\1\11\1\12\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\17",
            "\1\20",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3",
            "\1\4\10\uffff\1\5\2\uffff\1\1\1\2\1\3"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "1222:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );";
        }
    }
    static final String DFA6_eotS =
        "\25\uffff";
    static final String DFA6_eofS =
        "\25\uffff";
    static final String DFA6_minS =
        "\1\54\2\4\2\33\4\4\1\62\1\33\1\62\1\33\1\4\2\uffff\1\4\2\uffff"+
        "\2\55";
    static final String DFA6_maxS =
        "\1\64\2\4\2\62\4\4\1\62\1\63\1\62\1\63\1\4\2\uffff\1\4\2\uffff"+
        "\2\63";
    static final String DFA6_acceptS =
        "\16\uffff\1\2\1\1\1\uffff\1\4\1\3\2\uffff";
    static final String DFA6_specialS =
        "\25\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\7\uffff\1\2",
            "\1\3",
            "\1\4",
            "\1\5\26\uffff\1\6",
            "\1\7\26\uffff\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\6",
            "\1\15\21\uffff\1\17\5\uffff\1\16",
            "\1\10",
            "\1\20\21\uffff\1\22\5\uffff\1\21",
            "\1\23",
            "",
            "",
            "\1\24",
            "",
            "",
            "\1\17\5\uffff\1\16",
            "\1\22\5\uffff\1\21"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1322:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );";
        }
    }
 

    public static final BitSet FOLLOW_rulePackageDeclaration_in_entryRulePackageDeclaration61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDeclaration68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0_in_rulePackageDeclaration94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_entryRuleDOUBLE121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOUBLE128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__0_in_ruleDOUBLE154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsage_in_entryRuleUsage301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUsage308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Usage__Alternatives_in_ruleUsage334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_entryRuleIQUsage361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQUsage368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__0_in_ruleIQUsage394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_entryRuleEventSourceUsage421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventSourceUsage428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__0_in_ruleEventSourceUsage454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Event__Alternatives_in_ruleEvent583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_entryRuleAbstractAtomicEvent610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractAtomicEvent617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractAtomicEvent__Alternatives_in_ruleAbstractAtomicEvent643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_entryRuleAtomicEvent670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtomicEvent677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__0_in_ruleAtomicEvent703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_entryRuleIQPatternEvent730 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQPatternEvent737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__0_in_ruleIQPatternEvent763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_entryRuleComplexEvent790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexEvent797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__0_in_ruleComplexEvent823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_entryRuleCEParamlist850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCEParamlist857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__0_in_ruleCEParamlist883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventParamWithType_in_entryRuleEventParamWithType910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventParamWithType917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__0_in_ruleEventParamWithType943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_entryRuleParameterFilter970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterFilter977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__0_in_ruleParameterFilter1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_entryRuleAnnotations1030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotations1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotations__Alternatives_in_ruleAnnotations1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation1090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextAnnotation1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__0_in_ruleContextAnnotation1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation1150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSamplingAnnotation1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__0_in_ruleSamplingAnnotation1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation1210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePriorityAnnotation1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__0_in_rulePriorityAnnotation1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule1270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterFilterRule1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilterRule__Alternatives_in_ruleParameterFilterRule1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter1330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeFilter1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__0_in_ruleRangeFilter1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Range__Alternatives_in_ruleRange1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen1450 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenOpen1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__0_in_ruleOpenOpen1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed1510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenClosed1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__0_in_ruleOpenClosed1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedClosed1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__0_in_ruleClosedClosed1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen1630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedOpen1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__0_in_ruleClosedOpen1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter1690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericFilter1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__0_in_ruleNumericFilter1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator1750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericOperator1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter1810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFilter1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__0_in_ruleLiteralFilter1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator1870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralOperator1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralOperator__Alternatives_in_ruleLiteralOperator1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor1930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegationOpartor1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleNegationOpartor1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEventExpression_in_entryRuleComplexEventExpression1992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexEventExpression1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsExpression_in_ruleComplexEventExpression2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsExpression_in_entryRuleFollowsExpression2051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsExpression2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__0_in_ruleFollowsExpression2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithFollowsOperator_in_entryRuleEventWithFollowsOperator2111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventWithFollowsOperator2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__0_in_ruleEventWithFollowsOperator2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperator_in_entryRuleFollowsOperator2171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperator2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperator__Alternatives_in_ruleFollowsOperator2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorNoTW_in_entryRuleFollowsOperatorNoTW2231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperatorNoTW2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__0_in_ruleFollowsOperatorNoTW2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorViaTW_in_entryRuleFollowsOperatorViaTW2291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperatorViaTW2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__0_in_ruleFollowsOperatorViaTW2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_entryRuleEventWithMultiplicity2351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventWithMultiplicity2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__0_in_ruleEventWithMultiplicity2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Alternatives_in_ruleContext2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives2875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralOperator__Alternatives2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralOperator__Alternatives3010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralOperator__Alternatives3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorNoTW_in_rule__FollowsOperator__Alternatives3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorViaTW_in_rule__FollowsOperator__Alternatives3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IQPatternChangeType__Alternatives3114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__IQPatternChangeType__Alternatives3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Context__Alternatives3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Context__Alternatives3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Context__Alternatives3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__03246 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__03249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__13308 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__13311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__23368 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__23371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl3398 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03494 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03615 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03737 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3823 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03858 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03980 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__14039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__04105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__04108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IQUsage__Group__0__Impl4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__14167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__04228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__04231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl4259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__14290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04351 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl4381 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14412 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Model__Group__1__Impl4443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24474 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34534 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Model__Group__3__Impl4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44596 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4626 = new BitSet(new long[]{0x0001C90400000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Model__Group__5__Impl4685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04728 = new BitSet(new long[]{0x0001C00400000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4758 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14789 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24851 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34911 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__44973 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__44976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__55035 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__55038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__65097 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__65100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__75159 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__75162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__IdAssignment_7_in_rule__AtomicEvent__Group__7__Impl5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__85219 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__85222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__95281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__95284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__105343 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__105346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__SourceAssignment_10_in_rule__AtomicEvent__Group__10__Impl5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__115403 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__115406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125465 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135527 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5559 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5571 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145604 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05757 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15819 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25879 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__35941 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__35944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__46003 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__46006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl6034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__56065 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__56068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl6096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__66127 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__66130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__76187 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__76190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__86249 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__86252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__96311 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__96314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__106371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06452 = new BitSet(new long[]{0x0001C90400000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6482 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26575 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36635 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46695 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56757 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__6_in_rule__ComplexEvent__Group__56760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__ComplexEventExpressionsAssignment_5_in_rule__ComplexEvent__Group__5__Impl6787 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__6__Impl_in_rule__ComplexEvent__Group__66818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ComplexEvent__Group__6__Impl6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06891 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__16952 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__16955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__CEParamlist__Group__1__Impl6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__27014 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__27017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl7044 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__37075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__CEParamlist__Group__3__Impl7103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__0__Impl_in_rule__EventParamWithType__Group__07142 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__1_in_rule__EventParamWithType__Group__07145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__NameAssignment_0_in_rule__EventParamWithType__Group__0__Impl7172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__1__Impl_in_rule__EventParamWithType__Group__17202 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__2_in_rule__EventParamWithType__Group__17205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__EventParamWithType__Group__1__Impl7233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__2__Impl_in_rule__EventParamWithType__Group__27264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__TypeAssignment_2_in_rule__EventParamWithType__Group__2__Impl7291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__07327 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__07330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl7357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__17387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl7414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__07448 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__07451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17510 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27572 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07699 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27823 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__07950 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__07953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl7981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__18012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__18015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl8043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__28074 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__28077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl8104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__38134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl8162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__08201 = new BitSet(new long[]{0x0002000000000800L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__08204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl8231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__18262 = new BitSet(new long[]{0x0010100000000000L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__18265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__RangeFilter__Group__1__Impl8293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__28324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl8351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__08387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__08390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenOpen__Group__0__Impl8418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__18449 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__18452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28509 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38571 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18762 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28822 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38884 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__48944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__OpenClosed__Group__4__Impl8972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__09013 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__09016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl9044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__19075 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__19078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl9105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__29135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__29138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl9166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__39197 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__39200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl9227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__49257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl9285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__09326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__09329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl9357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__19388 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__19391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl9418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__29448 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__29451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39510 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09760 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19821 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__0__Impl_in_rule__FollowsExpression__Group__09944 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__1_in_rule__FollowsExpression__Group__09947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__FirstEventAssignment_0_in_rule__FollowsExpression__Group__0__Impl9974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__1__Impl_in_rule__FollowsExpression__Group__110004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__EventsAssignment_1_in_rule__FollowsExpression__Group__1__Impl10031 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__0__Impl_in_rule__EventWithFollowsOperator__Group__010066 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__1_in_rule__EventWithFollowsOperator__Group__010069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__OperatorAssignment_0_in_rule__EventWithFollowsOperator__Group__0__Impl10096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__1__Impl_in_rule__EventWithFollowsOperator__Group__110126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__EventAssignment_1_in_rule__EventWithFollowsOperator__Group__1__Impl10153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__0__Impl_in_rule__FollowsOperatorNoTW__Group__010187 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__1_in_rule__FollowsOperatorNoTW__Group__010190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__1__Impl_in_rule__FollowsOperatorNoTW__Group__110248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__FollowsOperatorNoTW__Group__1__Impl10276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__0__Impl_in_rule__FollowsOperatorViaTW__Group__010311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__1_in_rule__FollowsOperatorViaTW__Group__010314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FollowsOperatorViaTW__Group__0__Impl10342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__1__Impl_in_rule__FollowsOperatorViaTW__Group__110373 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__2_in_rule__FollowsOperatorViaTW__Group__110376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__TimewindowAssignment_1_in_rule__FollowsOperatorViaTW__Group__1__Impl10403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__2__Impl_in_rule__FollowsOperatorViaTW__Group__210433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__FollowsOperatorViaTW__Group__2__Impl10461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__0__Impl_in_rule__EventWithMultiplicity__Group__010498 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__1_in_rule__EventWithMultiplicity__Group__010501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__EventAssignment_0_in_rule__EventWithMultiplicity__Group__0__Impl10528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__1__Impl_in_rule__EventWithMultiplicity__Group__110558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__0_in_rule__EventWithMultiplicity__Group__1__Impl10585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__0__Impl_in_rule__EventWithMultiplicity__Group_1__010620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__1_in_rule__EventWithMultiplicity__Group_1__010623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EventWithMultiplicity__Group_1__0__Impl10651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__1__Impl_in_rule__EventWithMultiplicity__Group_1__110682 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__2_in_rule__EventWithMultiplicity__Group_1__110685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__MultiplicityAssignment_1_1_in_rule__EventWithMultiplicity__Group_1__1__Impl10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__2__Impl_in_rule__EventWithMultiplicity__Group_1__210742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EventWithMultiplicity__Group_1__2__Impl10770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_110812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_210843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_310874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_110905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_110936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_010967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_210998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_411029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_011060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_211091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_711122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_1011157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_1311192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_111223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__IQPatternEvent__IqpatternAssignment_611254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_911285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_011316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_211347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_311378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEventExpression_in_rule__ComplexEvent__ComplexEventExpressionsAssignment_511409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventParamWithType_in_rule__CEParamlist__ParamsAssignment_211440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventParamWithType__NameAssignment_011471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventParamWithType__TypeAssignment_211506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_011541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_111572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_211603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_211634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_211665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_011696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_211727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_111758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_311789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_111820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_311851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_111882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_311913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_111944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_311975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_012006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_112037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_012068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_112099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_212130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_rule__FollowsExpression__FirstEventAssignment_012161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithFollowsOperator_in_rule__FollowsExpression__EventsAssignment_112192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperator_in_rule__EventWithFollowsOperator__OperatorAssignment_012223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_rule__EventWithFollowsOperator__EventAssignment_112254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FollowsOperatorViaTW__TimewindowAssignment_112285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventWithMultiplicity__EventAssignment_012320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EventWithMultiplicity__MultiplicityAssignment_1_112355 = new BitSet(new long[]{0x0000000000000002L});

}