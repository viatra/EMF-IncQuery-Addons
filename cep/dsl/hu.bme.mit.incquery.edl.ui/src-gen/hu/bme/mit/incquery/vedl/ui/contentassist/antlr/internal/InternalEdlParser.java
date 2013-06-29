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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'<'", "'=<'", "'=='", "'!='", "'>='", "'>'", "'contains'", "'startsWith'", "'endsWith'", "'FOUND'", "'LOST'", "'Chronicle'", "'Recent'", "'Unrestricted'", "'package'", "'.'", "'.*'", "'uses-incquery-patterns'", "'uses-eventsources'", "'EventModel'", "'{'", "'}'", "'AtomicEvent'", "'()'", "'source'", "':'", "'id'", "'parameterFilters'", "'IQPatternEvent'", "'IQPatternRef'", "'ChangeType'", "'ComplexEvent'", "'('", "')'", "'@Context'", "'@SamplingTime'", "'@Priority'", "'in'", "','", "']'", "'['", "'->'", "'-['", "']->'"
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


    // $ANTLR start "entryRuleIQPattern"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:516:1: entryRuleIQPattern : ruleIQPattern EOF ;
    public final void entryRuleIQPattern() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:517:1: ( ruleIQPattern EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:518:1: ruleIQPattern EOF
            {
             before(grammarAccess.getIQPatternRule()); 
            pushFollow(FOLLOW_ruleIQPattern_in_entryRuleIQPattern1030);
            ruleIQPattern();

            state._fsp--;

             after(grammarAccess.getIQPatternRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIQPattern1037); 

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
    // $ANTLR end "entryRuleIQPattern"


    // $ANTLR start "ruleIQPattern"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:525:1: ruleIQPattern : ( ( rule__IQPattern__NameAssignment ) ) ;
    public final void ruleIQPattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:529:2: ( ( ( rule__IQPattern__NameAssignment ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:530:1: ( ( rule__IQPattern__NameAssignment ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:530:1: ( ( rule__IQPattern__NameAssignment ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:531:1: ( rule__IQPattern__NameAssignment )
            {
             before(grammarAccess.getIQPatternAccess().getNameAssignment()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:532:1: ( rule__IQPattern__NameAssignment )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:532:2: rule__IQPattern__NameAssignment
            {
            pushFollow(FOLLOW_rule__IQPattern__NameAssignment_in_ruleIQPattern1063);
            rule__IQPattern__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIQPatternAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleIQPattern"


    // $ANTLR start "entryRuleAnnotations"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:544:1: entryRuleAnnotations : ruleAnnotations EOF ;
    public final void entryRuleAnnotations() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:545:1: ( ruleAnnotations EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:546:1: ruleAnnotations EOF
            {
             before(grammarAccess.getAnnotationsRule()); 
            pushFollow(FOLLOW_ruleAnnotations_in_entryRuleAnnotations1090);
            ruleAnnotations();

            state._fsp--;

             after(grammarAccess.getAnnotationsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotations1097); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:553:1: ruleAnnotations : ( ( rule__Annotations__Alternatives ) ) ;
    public final void ruleAnnotations() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:557:2: ( ( ( rule__Annotations__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:558:1: ( ( rule__Annotations__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:558:1: ( ( rule__Annotations__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:559:1: ( rule__Annotations__Alternatives )
            {
             before(grammarAccess.getAnnotationsAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:560:1: ( rule__Annotations__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:560:2: rule__Annotations__Alternatives
            {
            pushFollow(FOLLOW_rule__Annotations__Alternatives_in_ruleAnnotations1123);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:572:1: entryRuleContextAnnotation : ruleContextAnnotation EOF ;
    public final void entryRuleContextAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:573:1: ( ruleContextAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:574:1: ruleContextAnnotation EOF
            {
             before(grammarAccess.getContextAnnotationRule()); 
            pushFollow(FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation1150);
            ruleContextAnnotation();

            state._fsp--;

             after(grammarAccess.getContextAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextAnnotation1157); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:581:1: ruleContextAnnotation : ( ( rule__ContextAnnotation__Group__0 ) ) ;
    public final void ruleContextAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:585:2: ( ( ( rule__ContextAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:586:1: ( ( rule__ContextAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:586:1: ( ( rule__ContextAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:587:1: ( rule__ContextAnnotation__Group__0 )
            {
             before(grammarAccess.getContextAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:588:1: ( rule__ContextAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:588:2: rule__ContextAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__0_in_ruleContextAnnotation1183);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:600:1: entryRuleSamplingAnnotation : ruleSamplingAnnotation EOF ;
    public final void entryRuleSamplingAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:601:1: ( ruleSamplingAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:602:1: ruleSamplingAnnotation EOF
            {
             before(grammarAccess.getSamplingAnnotationRule()); 
            pushFollow(FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation1210);
            ruleSamplingAnnotation();

            state._fsp--;

             after(grammarAccess.getSamplingAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSamplingAnnotation1217); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:609:1: ruleSamplingAnnotation : ( ( rule__SamplingAnnotation__Group__0 ) ) ;
    public final void ruleSamplingAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:613:2: ( ( ( rule__SamplingAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:614:1: ( ( rule__SamplingAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:614:1: ( ( rule__SamplingAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:615:1: ( rule__SamplingAnnotation__Group__0 )
            {
             before(grammarAccess.getSamplingAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:616:1: ( rule__SamplingAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:616:2: rule__SamplingAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__0_in_ruleSamplingAnnotation1243);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:628:1: entryRulePriorityAnnotation : rulePriorityAnnotation EOF ;
    public final void entryRulePriorityAnnotation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:629:1: ( rulePriorityAnnotation EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:630:1: rulePriorityAnnotation EOF
            {
             before(grammarAccess.getPriorityAnnotationRule()); 
            pushFollow(FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation1270);
            rulePriorityAnnotation();

            state._fsp--;

             after(grammarAccess.getPriorityAnnotationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePriorityAnnotation1277); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:637:1: rulePriorityAnnotation : ( ( rule__PriorityAnnotation__Group__0 ) ) ;
    public final void rulePriorityAnnotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:641:2: ( ( ( rule__PriorityAnnotation__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:642:1: ( ( rule__PriorityAnnotation__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:642:1: ( ( rule__PriorityAnnotation__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:643:1: ( rule__PriorityAnnotation__Group__0 )
            {
             before(grammarAccess.getPriorityAnnotationAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:644:1: ( rule__PriorityAnnotation__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:644:2: rule__PriorityAnnotation__Group__0
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__0_in_rulePriorityAnnotation1303);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:656:1: entryRuleParameterFilterRule : ruleParameterFilterRule EOF ;
    public final void entryRuleParameterFilterRule() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:657:1: ( ruleParameterFilterRule EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:658:1: ruleParameterFilterRule EOF
            {
             before(grammarAccess.getParameterFilterRuleRule()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule1330);
            ruleParameterFilterRule();

            state._fsp--;

             after(grammarAccess.getParameterFilterRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterFilterRule1337); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:665:1: ruleParameterFilterRule : ( ( rule__ParameterFilterRule__Alternatives ) ) ;
    public final void ruleParameterFilterRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:669:2: ( ( ( rule__ParameterFilterRule__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:670:1: ( ( rule__ParameterFilterRule__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:670:1: ( ( rule__ParameterFilterRule__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:671:1: ( rule__ParameterFilterRule__Alternatives )
            {
             before(grammarAccess.getParameterFilterRuleAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:672:1: ( rule__ParameterFilterRule__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:672:2: rule__ParameterFilterRule__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterFilterRule__Alternatives_in_ruleParameterFilterRule1363);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:684:1: entryRuleRangeFilter : ruleRangeFilter EOF ;
    public final void entryRuleRangeFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:685:1: ( ruleRangeFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:686:1: ruleRangeFilter EOF
            {
             before(grammarAccess.getRangeFilterRule()); 
            pushFollow(FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter1390);
            ruleRangeFilter();

            state._fsp--;

             after(grammarAccess.getRangeFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeFilter1397); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:693:1: ruleRangeFilter : ( ( rule__RangeFilter__Group__0 ) ) ;
    public final void ruleRangeFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:697:2: ( ( ( rule__RangeFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:698:1: ( ( rule__RangeFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:698:1: ( ( rule__RangeFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:699:1: ( rule__RangeFilter__Group__0 )
            {
             before(grammarAccess.getRangeFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:700:1: ( rule__RangeFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:700:2: rule__RangeFilter__Group__0
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__0_in_ruleRangeFilter1423);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:712:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:713:1: ( ruleRange EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:714:1: ruleRange EOF
            {
             before(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange1450);
            ruleRange();

            state._fsp--;

             after(grammarAccess.getRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange1457); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:721:1: ruleRange : ( ( rule__Range__Alternatives ) ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:725:2: ( ( ( rule__Range__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:726:1: ( ( rule__Range__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:726:1: ( ( rule__Range__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:727:1: ( rule__Range__Alternatives )
            {
             before(grammarAccess.getRangeAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:728:1: ( rule__Range__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:728:2: rule__Range__Alternatives
            {
            pushFollow(FOLLOW_rule__Range__Alternatives_in_ruleRange1483);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:740:1: entryRuleOpenOpen : ruleOpenOpen EOF ;
    public final void entryRuleOpenOpen() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:741:1: ( ruleOpenOpen EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:742:1: ruleOpenOpen EOF
            {
             before(grammarAccess.getOpenOpenRule()); 
            pushFollow(FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen1510);
            ruleOpenOpen();

            state._fsp--;

             after(grammarAccess.getOpenOpenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenOpen1517); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:749:1: ruleOpenOpen : ( ( rule__OpenOpen__Group__0 ) ) ;
    public final void ruleOpenOpen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:753:2: ( ( ( rule__OpenOpen__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:754:1: ( ( rule__OpenOpen__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:754:1: ( ( rule__OpenOpen__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:755:1: ( rule__OpenOpen__Group__0 )
            {
             before(grammarAccess.getOpenOpenAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:756:1: ( rule__OpenOpen__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:756:2: rule__OpenOpen__Group__0
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__0_in_ruleOpenOpen1543);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:768:1: entryRuleOpenClosed : ruleOpenClosed EOF ;
    public final void entryRuleOpenClosed() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:769:1: ( ruleOpenClosed EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:770:1: ruleOpenClosed EOF
            {
             before(grammarAccess.getOpenClosedRule()); 
            pushFollow(FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed1570);
            ruleOpenClosed();

            state._fsp--;

             after(grammarAccess.getOpenClosedRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOpenClosed1577); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:777:1: ruleOpenClosed : ( ( rule__OpenClosed__Group__0 ) ) ;
    public final void ruleOpenClosed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:781:2: ( ( ( rule__OpenClosed__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:782:1: ( ( rule__OpenClosed__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:782:1: ( ( rule__OpenClosed__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:783:1: ( rule__OpenClosed__Group__0 )
            {
             before(grammarAccess.getOpenClosedAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:784:1: ( rule__OpenClosed__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:784:2: rule__OpenClosed__Group__0
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__0_in_ruleOpenClosed1603);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:796:1: entryRuleClosedClosed : ruleClosedClosed EOF ;
    public final void entryRuleClosedClosed() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:797:1: ( ruleClosedClosed EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:798:1: ruleClosedClosed EOF
            {
             before(grammarAccess.getClosedClosedRule()); 
            pushFollow(FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed1630);
            ruleClosedClosed();

            state._fsp--;

             after(grammarAccess.getClosedClosedRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedClosed1637); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:805:1: ruleClosedClosed : ( ( rule__ClosedClosed__Group__0 ) ) ;
    public final void ruleClosedClosed() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:809:2: ( ( ( rule__ClosedClosed__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:810:1: ( ( rule__ClosedClosed__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:810:1: ( ( rule__ClosedClosed__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:811:1: ( rule__ClosedClosed__Group__0 )
            {
             before(grammarAccess.getClosedClosedAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:812:1: ( rule__ClosedClosed__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:812:2: rule__ClosedClosed__Group__0
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__0_in_ruleClosedClosed1663);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:824:1: entryRuleClosedOpen : ruleClosedOpen EOF ;
    public final void entryRuleClosedOpen() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:825:1: ( ruleClosedOpen EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:826:1: ruleClosedOpen EOF
            {
             before(grammarAccess.getClosedOpenRule()); 
            pushFollow(FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen1690);
            ruleClosedOpen();

            state._fsp--;

             after(grammarAccess.getClosedOpenRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClosedOpen1697); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:833:1: ruleClosedOpen : ( ( rule__ClosedOpen__Group__0 ) ) ;
    public final void ruleClosedOpen() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:837:2: ( ( ( rule__ClosedOpen__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:838:1: ( ( rule__ClosedOpen__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:838:1: ( ( rule__ClosedOpen__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:839:1: ( rule__ClosedOpen__Group__0 )
            {
             before(grammarAccess.getClosedOpenAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:840:1: ( rule__ClosedOpen__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:840:2: rule__ClosedOpen__Group__0
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__0_in_ruleClosedOpen1723);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:852:1: entryRuleNumericFilter : ruleNumericFilter EOF ;
    public final void entryRuleNumericFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:853:1: ( ruleNumericFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:854:1: ruleNumericFilter EOF
            {
             before(grammarAccess.getNumericFilterRule()); 
            pushFollow(FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter1750);
            ruleNumericFilter();

            state._fsp--;

             after(grammarAccess.getNumericFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericFilter1757); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:861:1: ruleNumericFilter : ( ( rule__NumericFilter__Group__0 ) ) ;
    public final void ruleNumericFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:865:2: ( ( ( rule__NumericFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:866:1: ( ( rule__NumericFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:866:1: ( ( rule__NumericFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:867:1: ( rule__NumericFilter__Group__0 )
            {
             before(grammarAccess.getNumericFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:868:1: ( rule__NumericFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:868:2: rule__NumericFilter__Group__0
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__0_in_ruleNumericFilter1783);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:880:1: entryRuleNumericOperator : ruleNumericOperator EOF ;
    public final void entryRuleNumericOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:881:1: ( ruleNumericOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:882:1: ruleNumericOperator EOF
            {
             before(grammarAccess.getNumericOperatorRule()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator1810);
            ruleNumericOperator();

            state._fsp--;

             after(grammarAccess.getNumericOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericOperator1817); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:889:1: ruleNumericOperator : ( ( rule__NumericOperator__Alternatives ) ) ;
    public final void ruleNumericOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:893:2: ( ( ( rule__NumericOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:894:1: ( ( rule__NumericOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:894:1: ( ( rule__NumericOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:895:1: ( rule__NumericOperator__Alternatives )
            {
             before(grammarAccess.getNumericOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:896:1: ( rule__NumericOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:896:2: rule__NumericOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1843);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:908:1: entryRuleLiteralFilter : ruleLiteralFilter EOF ;
    public final void entryRuleLiteralFilter() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:909:1: ( ruleLiteralFilter EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:910:1: ruleLiteralFilter EOF
            {
             before(grammarAccess.getLiteralFilterRule()); 
            pushFollow(FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter1870);
            ruleLiteralFilter();

            state._fsp--;

             after(grammarAccess.getLiteralFilterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFilter1877); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:917:1: ruleLiteralFilter : ( ( rule__LiteralFilter__Group__0 ) ) ;
    public final void ruleLiteralFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:921:2: ( ( ( rule__LiteralFilter__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:922:1: ( ( rule__LiteralFilter__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:922:1: ( ( rule__LiteralFilter__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:923:1: ( rule__LiteralFilter__Group__0 )
            {
             before(grammarAccess.getLiteralFilterAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:924:1: ( rule__LiteralFilter__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:924:2: rule__LiteralFilter__Group__0
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__0_in_ruleLiteralFilter1903);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:936:1: entryRuleLiteralOperator : ruleLiteralOperator EOF ;
    public final void entryRuleLiteralOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:937:1: ( ruleLiteralOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:938:1: ruleLiteralOperator EOF
            {
             before(grammarAccess.getLiteralOperatorRule()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator1930);
            ruleLiteralOperator();

            state._fsp--;

             after(grammarAccess.getLiteralOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralOperator1937); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:945:1: ruleLiteralOperator : ( ( rule__LiteralOperator__Alternatives ) ) ;
    public final void ruleLiteralOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:949:2: ( ( ( rule__LiteralOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:950:1: ( ( rule__LiteralOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:950:1: ( ( rule__LiteralOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:951:1: ( rule__LiteralOperator__Alternatives )
            {
             before(grammarAccess.getLiteralOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:952:1: ( rule__LiteralOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:952:2: rule__LiteralOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__LiteralOperator__Alternatives_in_ruleLiteralOperator1963);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:964:1: entryRuleNegationOpartor : ruleNegationOpartor EOF ;
    public final void entryRuleNegationOpartor() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:965:1: ( ruleNegationOpartor EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:966:1: ruleNegationOpartor EOF
            {
             before(grammarAccess.getNegationOpartorRule()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor1990);
            ruleNegationOpartor();

            state._fsp--;

             after(grammarAccess.getNegationOpartorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegationOpartor1997); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:973:1: ruleNegationOpartor : ( 'not' ) ;
    public final void ruleNegationOpartor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:977:2: ( ( 'not' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:978:1: ( 'not' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:978:1: ( 'not' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:979:1: 'not'
            {
             before(grammarAccess.getNegationOpartorAccess().getNotKeyword()); 
            match(input,11,FOLLOW_11_in_ruleNegationOpartor2024); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:994:1: entryRuleComplexEventExpression : ruleComplexEventExpression EOF ;
    public final void entryRuleComplexEventExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:995:1: ( ruleComplexEventExpression EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:996:1: ruleComplexEventExpression EOF
            {
             before(grammarAccess.getComplexEventExpressionRule()); 
            pushFollow(FOLLOW_ruleComplexEventExpression_in_entryRuleComplexEventExpression2052);
            ruleComplexEventExpression();

            state._fsp--;

             after(grammarAccess.getComplexEventExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexEventExpression2059); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1003:1: ruleComplexEventExpression : ( ruleFollowsExpression ) ;
    public final void ruleComplexEventExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1007:2: ( ( ruleFollowsExpression ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1008:1: ( ruleFollowsExpression )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1008:1: ( ruleFollowsExpression )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1009:1: ruleFollowsExpression
            {
             before(grammarAccess.getComplexEventExpressionAccess().getFollowsExpressionParserRuleCall()); 
            pushFollow(FOLLOW_ruleFollowsExpression_in_ruleComplexEventExpression2085);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1022:1: entryRuleFollowsExpression : ruleFollowsExpression EOF ;
    public final void entryRuleFollowsExpression() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1023:1: ( ruleFollowsExpression EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1024:1: ruleFollowsExpression EOF
            {
             before(grammarAccess.getFollowsExpressionRule()); 
            pushFollow(FOLLOW_ruleFollowsExpression_in_entryRuleFollowsExpression2111);
            ruleFollowsExpression();

            state._fsp--;

             after(grammarAccess.getFollowsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsExpression2118); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1031:1: ruleFollowsExpression : ( ( rule__FollowsExpression__Group__0 ) ) ;
    public final void ruleFollowsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1035:2: ( ( ( rule__FollowsExpression__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1036:1: ( ( rule__FollowsExpression__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1036:1: ( ( rule__FollowsExpression__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1037:1: ( rule__FollowsExpression__Group__0 )
            {
             before(grammarAccess.getFollowsExpressionAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1038:1: ( rule__FollowsExpression__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1038:2: rule__FollowsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__0_in_ruleFollowsExpression2144);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1050:1: entryRuleEventWithFollowsOperator : ruleEventWithFollowsOperator EOF ;
    public final void entryRuleEventWithFollowsOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1051:1: ( ruleEventWithFollowsOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1052:1: ruleEventWithFollowsOperator EOF
            {
             before(grammarAccess.getEventWithFollowsOperatorRule()); 
            pushFollow(FOLLOW_ruleEventWithFollowsOperator_in_entryRuleEventWithFollowsOperator2171);
            ruleEventWithFollowsOperator();

            state._fsp--;

             after(grammarAccess.getEventWithFollowsOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventWithFollowsOperator2178); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1059:1: ruleEventWithFollowsOperator : ( ( rule__EventWithFollowsOperator__Group__0 ) ) ;
    public final void ruleEventWithFollowsOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1063:2: ( ( ( rule__EventWithFollowsOperator__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1064:1: ( ( rule__EventWithFollowsOperator__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1064:1: ( ( rule__EventWithFollowsOperator__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1065:1: ( rule__EventWithFollowsOperator__Group__0 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1066:1: ( rule__EventWithFollowsOperator__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1066:2: rule__EventWithFollowsOperator__Group__0
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__0_in_ruleEventWithFollowsOperator2204);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1078:1: entryRuleFollowsOperator : ruleFollowsOperator EOF ;
    public final void entryRuleFollowsOperator() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1079:1: ( ruleFollowsOperator EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1080:1: ruleFollowsOperator EOF
            {
             before(grammarAccess.getFollowsOperatorRule()); 
            pushFollow(FOLLOW_ruleFollowsOperator_in_entryRuleFollowsOperator2231);
            ruleFollowsOperator();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperator2238); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1087:1: ruleFollowsOperator : ( ( rule__FollowsOperator__Alternatives ) ) ;
    public final void ruleFollowsOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1091:2: ( ( ( rule__FollowsOperator__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1092:1: ( ( rule__FollowsOperator__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1092:1: ( ( rule__FollowsOperator__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1093:1: ( rule__FollowsOperator__Alternatives )
            {
             before(grammarAccess.getFollowsOperatorAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1094:1: ( rule__FollowsOperator__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1094:2: rule__FollowsOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__FollowsOperator__Alternatives_in_ruleFollowsOperator2264);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1106:1: entryRuleFollowsOperatorNoTW : ruleFollowsOperatorNoTW EOF ;
    public final void entryRuleFollowsOperatorNoTW() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1107:1: ( ruleFollowsOperatorNoTW EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1108:1: ruleFollowsOperatorNoTW EOF
            {
             before(grammarAccess.getFollowsOperatorNoTWRule()); 
            pushFollow(FOLLOW_ruleFollowsOperatorNoTW_in_entryRuleFollowsOperatorNoTW2291);
            ruleFollowsOperatorNoTW();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorNoTWRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperatorNoTW2298); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1115:1: ruleFollowsOperatorNoTW : ( ( rule__FollowsOperatorNoTW__Group__0 ) ) ;
    public final void ruleFollowsOperatorNoTW() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1119:2: ( ( ( rule__FollowsOperatorNoTW__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1120:1: ( ( rule__FollowsOperatorNoTW__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1120:1: ( ( rule__FollowsOperatorNoTW__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1121:1: ( rule__FollowsOperatorNoTW__Group__0 )
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1122:1: ( rule__FollowsOperatorNoTW__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1122:2: rule__FollowsOperatorNoTW__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__0_in_ruleFollowsOperatorNoTW2324);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1134:1: entryRuleFollowsOperatorViaTW : ruleFollowsOperatorViaTW EOF ;
    public final void entryRuleFollowsOperatorViaTW() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1135:1: ( ruleFollowsOperatorViaTW EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1136:1: ruleFollowsOperatorViaTW EOF
            {
             before(grammarAccess.getFollowsOperatorViaTWRule()); 
            pushFollow(FOLLOW_ruleFollowsOperatorViaTW_in_entryRuleFollowsOperatorViaTW2351);
            ruleFollowsOperatorViaTW();

            state._fsp--;

             after(grammarAccess.getFollowsOperatorViaTWRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFollowsOperatorViaTW2358); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1143:1: ruleFollowsOperatorViaTW : ( ( rule__FollowsOperatorViaTW__Group__0 ) ) ;
    public final void ruleFollowsOperatorViaTW() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1147:2: ( ( ( rule__FollowsOperatorViaTW__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1148:1: ( ( rule__FollowsOperatorViaTW__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1148:1: ( ( rule__FollowsOperatorViaTW__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1149:1: ( rule__FollowsOperatorViaTW__Group__0 )
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1150:1: ( rule__FollowsOperatorViaTW__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1150:2: rule__FollowsOperatorViaTW__Group__0
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__0_in_ruleFollowsOperatorViaTW2384);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1162:1: entryRuleEventWithMultiplicity : ruleEventWithMultiplicity EOF ;
    public final void entryRuleEventWithMultiplicity() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1163:1: ( ruleEventWithMultiplicity EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1164:1: ruleEventWithMultiplicity EOF
            {
             before(grammarAccess.getEventWithMultiplicityRule()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_entryRuleEventWithMultiplicity2411);
            ruleEventWithMultiplicity();

            state._fsp--;

             after(grammarAccess.getEventWithMultiplicityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEventWithMultiplicity2418); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1171:1: ruleEventWithMultiplicity : ( ( rule__EventWithMultiplicity__Group__0 ) ) ;
    public final void ruleEventWithMultiplicity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1175:2: ( ( ( rule__EventWithMultiplicity__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1176:1: ( ( rule__EventWithMultiplicity__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1176:1: ( ( rule__EventWithMultiplicity__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1177:1: ( rule__EventWithMultiplicity__Group__0 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1178:1: ( rule__EventWithMultiplicity__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1178:2: rule__EventWithMultiplicity__Group__0
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__0_in_ruleEventWithMultiplicity2444);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1191:1: ruleIQPatternChangeType : ( ( rule__IQPatternChangeType__Alternatives ) ) ;
    public final void ruleIQPatternChangeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1195:1: ( ( ( rule__IQPatternChangeType__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1196:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1196:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1197:1: ( rule__IQPatternChangeType__Alternatives )
            {
             before(grammarAccess.getIQPatternChangeTypeAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1198:1: ( rule__IQPatternChangeType__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1198:2: rule__IQPatternChangeType__Alternatives
            {
            pushFollow(FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2481);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1210:1: ruleContext : ( ( rule__Context__Alternatives ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1214:1: ( ( ( rule__Context__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1215:1: ( ( rule__Context__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1215:1: ( ( rule__Context__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1216:1: ( rule__Context__Alternatives )
            {
             before(grammarAccess.getContextAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1217:1: ( rule__Context__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1217:2: rule__Context__Alternatives
            {
            pushFollow(FOLLOW_rule__Context__Alternatives_in_ruleContext2517);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1228:1: rule__Usage__Alternatives : ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) );
    public final void rule__Usage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1232:1: ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:1: ( ruleIQUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:1: ( ruleIQUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1234:1: ruleIQUsage
                    {
                     before(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2552);
                    ruleIQUsage();

                    state._fsp--;

                     after(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1239:6: ( ruleEventSourceUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1239:6: ( ruleEventSourceUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1240:1: ruleEventSourceUsage
                    {
                     before(grammarAccess.getUsageAccess().getEventSourceUsageParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2569);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1250:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );
    public final void rule__Event__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1254:1: ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1255:1: ( ruleAbstractAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1255:1: ( ruleAbstractAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1256:1: ruleAbstractAtomicEvent
                    {
                     before(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2601);
                    ruleAbstractAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1261:6: ( ruleComplexEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1261:6: ( ruleComplexEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1262:1: ruleComplexEvent
                    {
                     before(grammarAccess.getEventAccess().getComplexEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2618);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1272:1: rule__AbstractAtomicEvent__Alternatives : ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) );
    public final void rule__AbstractAtomicEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1276:1: ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1277:1: ( ruleAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1277:1: ( ruleAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1278:1: ruleAtomicEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2650);
                    ruleAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1283:6: ( ruleIQPatternEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1283:6: ( ruleIQPatternEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1284:1: ruleIQPatternEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getIQPatternEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2667);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1294:1: rule__Annotations__Alternatives : ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) );
    public final void rule__Annotations__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1298:1: ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1299:1: ( ruleContextAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1299:1: ( ruleContextAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1300:1: ruleContextAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2699);
                    ruleContextAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1305:6: ( ruleSamplingAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1305:6: ( ruleSamplingAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1306:1: ruleSamplingAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2716);
                    ruleSamplingAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:6: ( rulePriorityAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:6: ( rulePriorityAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1312:1: rulePriorityAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getPriorityAnnotationParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2733);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1322:1: rule__ParameterFilterRule__Alternatives : ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) );
    public final void rule__ParameterFilterRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1326:1: ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1327:1: ( ruleRangeFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1327:1: ( ruleRangeFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1328:1: ruleRangeFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2765);
                    ruleRangeFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1333:6: ( ruleNumericFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1333:6: ( ruleNumericFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1334:1: ruleNumericFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2782);
                    ruleNumericFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1339:6: ( ruleLiteralFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1339:6: ( ruleLiteralFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1340:1: ruleLiteralFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getLiteralFilterParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2799);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1350:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );
    public final void rule__Range__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1354:1: ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1355:1: ( ruleOpenOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1355:1: ( ruleOpenOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1356:1: ruleOpenOpen
                    {
                     before(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2831);
                    ruleOpenOpen();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1361:6: ( ruleOpenClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1361:6: ( ruleOpenClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1362:1: ruleOpenClosed
                    {
                     before(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2848);
                    ruleOpenClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1367:6: ( ruleClosedClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1367:6: ( ruleClosedClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1368:1: ruleClosedClosed
                    {
                     before(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2865);
                    ruleClosedClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1373:6: ( ruleClosedOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1373:6: ( ruleClosedOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1374:1: ruleClosedOpen
                    {
                     before(grammarAccess.getRangeAccess().getClosedOpenParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2882);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1384:1: rule__NumericOperator__Alternatives : ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1388:1: ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1389:1: ( '<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1389:1: ( '<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1390:1: '<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__NumericOperator__Alternatives2915); 
                     after(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1397:6: ( '=<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1397:6: ( '=<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1398:1: '=<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__NumericOperator__Alternatives2935); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1405:6: ( '==' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1405:6: ( '==' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1406:1: '=='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__NumericOperator__Alternatives2955); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1413:6: ( '!=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1413:6: ( '!=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1414:1: '!='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 
                    match(input,15,FOLLOW_15_in_rule__NumericOperator__Alternatives2975); 
                     after(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1421:6: ( '>=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1421:6: ( '>=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1422:1: '>='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 
                    match(input,16,FOLLOW_16_in_rule__NumericOperator__Alternatives2995); 
                     after(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1429:6: ( '>' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1429:6: ( '>' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1430:1: '>'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignKeyword_5()); 
                    match(input,17,FOLLOW_17_in_rule__NumericOperator__Alternatives3015); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1442:1: rule__LiteralOperator__Alternatives : ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) );
    public final void rule__LiteralOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1446:1: ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1447:1: ( 'contains' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1447:1: ( 'contains' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1448:1: 'contains'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__LiteralOperator__Alternatives3050); 
                     after(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1455:6: ( 'startsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1455:6: ( 'startsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1456:1: 'startsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__LiteralOperator__Alternatives3070); 
                     after(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1463:6: ( 'endsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1463:6: ( 'endsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1464:1: 'endsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getEndsWithKeyword_2()); 
                    match(input,20,FOLLOW_20_in_rule__LiteralOperator__Alternatives3090); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1476:1: rule__FollowsOperator__Alternatives : ( ( ruleFollowsOperatorNoTW ) | ( ruleFollowsOperatorViaTW ) );
    public final void rule__FollowsOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1480:1: ( ( ruleFollowsOperatorNoTW ) | ( ruleFollowsOperatorViaTW ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1481:1: ( ruleFollowsOperatorNoTW )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1481:1: ( ruleFollowsOperatorNoTW )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1482:1: ruleFollowsOperatorNoTW
                    {
                     before(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorNoTWParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFollowsOperatorNoTW_in_rule__FollowsOperator__Alternatives3124);
                    ruleFollowsOperatorNoTW();

                    state._fsp--;

                     after(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorNoTWParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1487:6: ( ruleFollowsOperatorViaTW )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1487:6: ( ruleFollowsOperatorViaTW )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1488:1: ruleFollowsOperatorViaTW
                    {
                     before(grammarAccess.getFollowsOperatorAccess().getFollowsOperatorViaTWParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleFollowsOperatorViaTW_in_rule__FollowsOperator__Alternatives3141);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1498:1: rule__IQPatternChangeType__Alternatives : ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) );
    public final void rule__IQPatternChangeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1502:1: ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1503:1: ( ( 'FOUND' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1503:1: ( ( 'FOUND' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1504:1: ( 'FOUND' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1505:1: ( 'FOUND' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1505:3: 'FOUND'
                    {
                    match(input,21,FOLLOW_21_in_rule__IQPatternChangeType__Alternatives3174); 

                    }

                     after(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1510:6: ( ( 'LOST' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1510:6: ( ( 'LOST' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1511:1: ( 'LOST' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1512:1: ( 'LOST' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1512:3: 'LOST'
                    {
                    match(input,22,FOLLOW_22_in_rule__IQPatternChangeType__Alternatives3195); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1522:1: rule__Context__Alternatives : ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) );
    public final void rule__Context__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1526:1: ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1527:1: ( ( 'Chronicle' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1527:1: ( ( 'Chronicle' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1528:1: ( 'Chronicle' )
                    {
                     before(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1529:1: ( 'Chronicle' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1529:3: 'Chronicle'
                    {
                    match(input,23,FOLLOW_23_in_rule__Context__Alternatives3231); 

                    }

                     after(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1534:6: ( ( 'Recent' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1534:6: ( ( 'Recent' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1535:1: ( 'Recent' )
                    {
                     before(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1536:1: ( 'Recent' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1536:3: 'Recent'
                    {
                    match(input,24,FOLLOW_24_in_rule__Context__Alternatives3252); 

                    }

                     after(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1541:6: ( ( 'Unrestricted' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1541:6: ( ( 'Unrestricted' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1542:1: ( 'Unrestricted' )
                    {
                     before(grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1543:1: ( 'Unrestricted' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1543:3: 'Unrestricted'
                    {
                    match(input,25,FOLLOW_25_in_rule__Context__Alternatives3273); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1555:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1559:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1560:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__03306);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__03309);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1567:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1571:1: ( ( 'package' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1572:1: ( 'package' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1572:1: ( 'package' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1573:1: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl3337); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1586:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1590:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1591:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__13368);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__13371);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1598:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1602:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1603:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1603:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1604:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1605:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1605:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl3398);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1615:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1619:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1620:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__23428);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__23431);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1627:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1631:1: ( ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1632:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1632:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1633:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1634:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=29 && LA12_0<=30)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1634:2: rule__PackageDeclaration__UsagesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl3458);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1644:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1648:1: ( rule__PackageDeclaration__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1649:2: rule__PackageDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33489);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1655:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1659:1: ( ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1660:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1660:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1661:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1662:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1662:2: rule__PackageDeclaration__ModelAssignment_3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3516);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1680:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1684:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1685:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03554);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03557);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1692:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1696:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1697:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1697:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1698:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3584); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1709:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1713:1: ( rule__DOUBLE__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1714:2: rule__DOUBLE__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13613);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1720:1: rule__DOUBLE__Group__1__Impl : ( ( rule__DOUBLE__Group_1__0 )? ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1724:1: ( ( ( rule__DOUBLE__Group_1__0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1725:1: ( ( rule__DOUBLE__Group_1__0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1725:1: ( ( rule__DOUBLE__Group_1__0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1726:1: ( rule__DOUBLE__Group_1__0 )?
            {
             before(grammarAccess.getDOUBLEAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1727:1: ( rule__DOUBLE__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==27) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1727:2: rule__DOUBLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3640);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1741:1: rule__DOUBLE__Group_1__0 : rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 ;
    public final void rule__DOUBLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1745:1: ( rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1746:2: rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03675);
            rule__DOUBLE__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03678);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1753:1: rule__DOUBLE__Group_1__0__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1757:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1758:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1758:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1759:1: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3706); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1772:1: rule__DOUBLE__Group_1__1 : rule__DOUBLE__Group_1__1__Impl ;
    public final void rule__DOUBLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1776:1: ( rule__DOUBLE__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1777:2: rule__DOUBLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13737);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1783:1: rule__DOUBLE__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1787:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1788:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1788:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1789:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3764); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1804:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1808:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1809:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03797);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03800);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1816:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1820:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1821:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1821:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1822:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3827); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1833:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1837:1: ( rule__QualifiedName__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1838:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13856);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1844:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1848:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1849:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1849:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1850:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1851:1: ( rule__QualifiedName__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==27) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1851:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3883);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1865:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1869:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1870:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03918);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03921);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1877:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1881:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1882:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1882:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1883:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3949); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1896:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1900:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1901:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13980);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1907:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1911:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1912:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1912:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1913:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4007); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1928:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1932:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1933:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__04040);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__04043);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1940:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1944:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1946:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl4070);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1957:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1961:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1962:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__14099);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1968:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1972:1: ( ( ( '.*' )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1973:1: ( ( '.*' )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1973:1: ( ( '.*' )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1974:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1975:1: ( '.*' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1976:2: '.*'
                    {
                    match(input,28,FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl4128); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1991:1: rule__IQUsage__Group__0 : rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 ;
    public final void rule__IQUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1995:1: ( rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1996:2: rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__04165);
            rule__IQUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__04168);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2003:1: rule__IQUsage__Group__0__Impl : ( 'uses-incquery-patterns' ) ;
    public final void rule__IQUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2007:1: ( ( 'uses-incquery-patterns' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2008:1: ( 'uses-incquery-patterns' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2008:1: ( 'uses-incquery-patterns' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2009:1: 'uses-incquery-patterns'
            {
             before(grammarAccess.getIQUsageAccess().getUsesIncqueryPatternsKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__IQUsage__Group__0__Impl4196); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2022:1: rule__IQUsage__Group__1 : rule__IQUsage__Group__1__Impl ;
    public final void rule__IQUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2026:1: ( rule__IQUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2027:2: rule__IQUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__14227);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2033:1: rule__IQUsage__Group__1__Impl : ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__IQUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2037:1: ( ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2038:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2038:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2039:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2040:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2040:2: rule__IQUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl4254);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2054:1: rule__EventSourceUsage__Group__0 : rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 ;
    public final void rule__EventSourceUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2058:1: ( rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2059:2: rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__04288);
            rule__EventSourceUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__04291);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2066:1: rule__EventSourceUsage__Group__0__Impl : ( 'uses-eventsources' ) ;
    public final void rule__EventSourceUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2070:1: ( ( 'uses-eventsources' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2071:1: ( 'uses-eventsources' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2071:1: ( 'uses-eventsources' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2072:1: 'uses-eventsources'
            {
             before(grammarAccess.getEventSourceUsageAccess().getUsesEventsourcesKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl4319); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2085:1: rule__EventSourceUsage__Group__1 : rule__EventSourceUsage__Group__1__Impl ;
    public final void rule__EventSourceUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2089:1: ( rule__EventSourceUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2090:2: rule__EventSourceUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__14350);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2096:1: rule__EventSourceUsage__Group__1__Impl : ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__EventSourceUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2100:1: ( ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2101:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2101:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2102:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2103:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2103:2: rule__EventSourceUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl4377);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2117:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2121:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2122:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04411);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04414);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2129:1: rule__Model__Group__0__Impl : ( ( rule__Model__AnnotationsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2133:1: ( ( ( rule__Model__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2134:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2134:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2135:1: ( rule__Model__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2136:1: ( rule__Model__AnnotationsAssignment_0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=46 && LA16_0<=48)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2136:2: rule__Model__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl4441);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2146:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2150:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2151:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14472);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14475);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2158:1: rule__Model__Group__1__Impl : ( 'EventModel' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2162:1: ( ( 'EventModel' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2163:1: ( 'EventModel' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2163:1: ( 'EventModel' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2164:1: 'EventModel'
            {
             before(grammarAccess.getModelAccess().getEventModelKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__Model__Group__1__Impl4503); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2177:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2181:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2182:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24534);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24537);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2189:1: rule__Model__Group__2__Impl : ( ( rule__Model__NameAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2193:1: ( ( ( rule__Model__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2194:1: ( ( rule__Model__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2194:1: ( ( rule__Model__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2195:1: ( rule__Model__NameAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2196:1: ( rule__Model__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2196:2: rule__Model__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4564);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2206:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2210:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2211:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34594);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34597);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2218:1: rule__Model__Group__3__Impl : ( '{' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2222:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2223:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2223:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2224:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__Model__Group__3__Impl4625); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2237:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2241:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2242:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44656);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44659);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2249:1: rule__Model__Group__4__Impl : ( ( rule__Model__EventsAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2253:1: ( ( ( rule__Model__EventsAssignment_4 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2254:1: ( ( rule__Model__EventsAssignment_4 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2254:1: ( ( rule__Model__EventsAssignment_4 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2255:1: ( rule__Model__EventsAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getEventsAssignment_4()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2256:1: ( rule__Model__EventsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==34||LA17_0==40||LA17_0==43||(LA17_0>=46 && LA17_0<=48)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2256:2: rule__Model__EventsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4686);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2266:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2270:1: ( rule__Model__Group__5__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2271:2: rule__Model__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54717);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2277:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2281:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2282:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2282:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2283:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,33,FOLLOW_33_in_rule__Model__Group__5__Impl4745); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2308:1: rule__AtomicEvent__Group__0 : rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 ;
    public final void rule__AtomicEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2312:1: ( rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2313:2: rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04788);
            rule__AtomicEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04791);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2320:1: rule__AtomicEvent__Group__0__Impl : ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__AtomicEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2324:1: ( ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2325:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2325:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2326:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2327:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=46 && LA18_0<=48)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2327:2: rule__AtomicEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4818);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2337:1: rule__AtomicEvent__Group__1 : rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 ;
    public final void rule__AtomicEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2341:1: ( rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2342:2: rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14849);
            rule__AtomicEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14852);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2349:1: rule__AtomicEvent__Group__1__Impl : ( 'AtomicEvent' ) ;
    public final void rule__AtomicEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2353:1: ( ( 'AtomicEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2354:1: ( 'AtomicEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2354:1: ( 'AtomicEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2355:1: 'AtomicEvent'
            {
             before(grammarAccess.getAtomicEventAccess().getAtomicEventKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4880); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2368:1: rule__AtomicEvent__Group__2 : rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 ;
    public final void rule__AtomicEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2372:1: ( rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2373:2: rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24911);
            rule__AtomicEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24914);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2380:1: rule__AtomicEvent__Group__2__Impl : ( ( rule__AtomicEvent__NameAssignment_2 ) ) ;
    public final void rule__AtomicEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2384:1: ( ( ( rule__AtomicEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2385:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2385:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2386:1: ( rule__AtomicEvent__NameAssignment_2 )
            {
             before(grammarAccess.getAtomicEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2387:1: ( rule__AtomicEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2387:2: rule__AtomicEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4941);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2397:1: rule__AtomicEvent__Group__3 : rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 ;
    public final void rule__AtomicEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2401:1: ( rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2402:2: rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34971);
            rule__AtomicEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34974);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2409:1: rule__AtomicEvent__Group__3__Impl : ( '()' ) ;
    public final void rule__AtomicEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2413:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2414:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2414:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2415:1: '()'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftParenthesisRightParenthesisKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl5002); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2428:1: rule__AtomicEvent__Group__4 : rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 ;
    public final void rule__AtomicEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2432:1: ( rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2433:2: rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__45033);
            rule__AtomicEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__45036);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2440:1: rule__AtomicEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2444:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2445:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2445:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2446:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl5064); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2459:1: rule__AtomicEvent__Group__5 : rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 ;
    public final void rule__AtomicEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2463:1: ( rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2464:2: rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__55095);
            rule__AtomicEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__55098);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2471:1: rule__AtomicEvent__Group__5__Impl : ( 'source' ) ;
    public final void rule__AtomicEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2475:1: ( ( 'source' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2476:1: ( 'source' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2476:1: ( 'source' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2477:1: 'source'
            {
             before(grammarAccess.getAtomicEventAccess().getSourceKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl5126); 
             after(grammarAccess.getAtomicEventAccess().getSourceKeyword_5()); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2490:1: rule__AtomicEvent__Group__6 : rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 ;
    public final void rule__AtomicEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2494:1: ( rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2495:2: rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__65157);
            rule__AtomicEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__65160);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2502:1: rule__AtomicEvent__Group__6__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2506:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2507:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2507:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2508:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl5188); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2521:1: rule__AtomicEvent__Group__7 : rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 ;
    public final void rule__AtomicEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2525:1: ( rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2526:2: rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__75219);
            rule__AtomicEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__75222);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2533:1: rule__AtomicEvent__Group__7__Impl : ( ( rule__AtomicEvent__SourceAssignment_7 ) ) ;
    public final void rule__AtomicEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2537:1: ( ( ( rule__AtomicEvent__SourceAssignment_7 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2538:1: ( ( rule__AtomicEvent__SourceAssignment_7 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2538:1: ( ( rule__AtomicEvent__SourceAssignment_7 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2539:1: ( rule__AtomicEvent__SourceAssignment_7 )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceAssignment_7()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2540:1: ( rule__AtomicEvent__SourceAssignment_7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2540:2: rule__AtomicEvent__SourceAssignment_7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__SourceAssignment_7_in_rule__AtomicEvent__Group__7__Impl5249);
            rule__AtomicEvent__SourceAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getSourceAssignment_7()); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2550:1: rule__AtomicEvent__Group__8 : rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 ;
    public final void rule__AtomicEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2554:1: ( rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2555:2: rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__85279);
            rule__AtomicEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__85282);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2562:1: rule__AtomicEvent__Group__8__Impl : ( 'id' ) ;
    public final void rule__AtomicEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2566:1: ( ( 'id' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2567:1: ( 'id' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2567:1: ( 'id' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2568:1: 'id'
            {
             before(grammarAccess.getAtomicEventAccess().getIdKeyword_8()); 
            match(input,38,FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl5310); 
             after(grammarAccess.getAtomicEventAccess().getIdKeyword_8()); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2581:1: rule__AtomicEvent__Group__9 : rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 ;
    public final void rule__AtomicEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2585:1: ( rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2586:2: rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__95341);
            rule__AtomicEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__95344);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2593:1: rule__AtomicEvent__Group__9__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2597:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2598:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2598:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2599:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_9()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl5372); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2612:1: rule__AtomicEvent__Group__10 : rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 ;
    public final void rule__AtomicEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2616:1: ( rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2617:2: rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__105403);
            rule__AtomicEvent__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__105406);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2624:1: rule__AtomicEvent__Group__10__Impl : ( ( rule__AtomicEvent__IdAssignment_10 ) ) ;
    public final void rule__AtomicEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2628:1: ( ( ( rule__AtomicEvent__IdAssignment_10 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2629:1: ( ( rule__AtomicEvent__IdAssignment_10 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2629:1: ( ( rule__AtomicEvent__IdAssignment_10 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2630:1: ( rule__AtomicEvent__IdAssignment_10 )
            {
             before(grammarAccess.getAtomicEventAccess().getIdAssignment_10()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2631:1: ( rule__AtomicEvent__IdAssignment_10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2631:2: rule__AtomicEvent__IdAssignment_10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__IdAssignment_10_in_rule__AtomicEvent__Group__10__Impl5433);
            rule__AtomicEvent__IdAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getIdAssignment_10()); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2641:1: rule__AtomicEvent__Group__11 : rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 ;
    public final void rule__AtomicEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2645:1: ( rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2646:2: rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__115463);
            rule__AtomicEvent__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__115466);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2653:1: rule__AtomicEvent__Group__11__Impl : ( 'parameterFilters' ) ;
    public final void rule__AtomicEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2657:1: ( ( 'parameterFilters' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2658:1: ( 'parameterFilters' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2658:1: ( 'parameterFilters' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2659:1: 'parameterFilters'
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersKeyword_11()); 
            match(input,39,FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5494); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2672:1: rule__AtomicEvent__Group__12 : rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 ;
    public final void rule__AtomicEvent__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2676:1: ( rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2677:2: rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125525);
            rule__AtomicEvent__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125528);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2684:1: rule__AtomicEvent__Group__12__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2688:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2689:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2689:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2690:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_12()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5556); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2703:1: rule__AtomicEvent__Group__13 : rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 ;
    public final void rule__AtomicEvent__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2707:1: ( rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2708:2: rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135587);
            rule__AtomicEvent__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135590);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2715:1: rule__AtomicEvent__Group__13__Impl : ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) ;
    public final void rule__AtomicEvent__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2719:1: ( ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2720:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2720:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2721:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2721:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2722:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2723:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2723:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5619);
            rule__AtomicEvent__ParameterFiltersAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 

            }

            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2726:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2727:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2728:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2728:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5631);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2739:1: rule__AtomicEvent__Group__14 : rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 ;
    public final void rule__AtomicEvent__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2743:1: ( rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2744:2: rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145664);
            rule__AtomicEvent__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145667);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2751:1: rule__AtomicEvent__Group__14__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2755:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2756:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2756:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2757:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_14()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5695); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2770:1: rule__AtomicEvent__Group__15 : rule__AtomicEvent__Group__15__Impl ;
    public final void rule__AtomicEvent__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2774:1: ( rule__AtomicEvent__Group__15__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2775:2: rule__AtomicEvent__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155726);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2781:1: rule__AtomicEvent__Group__15__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2785:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2786:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2786:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2787:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_15()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5754); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2832:1: rule__IQPatternEvent__Group__0 : rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 ;
    public final void rule__IQPatternEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2836:1: ( rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2837:2: rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05817);
            rule__IQPatternEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05820);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2844:1: rule__IQPatternEvent__Group__0__Impl : ( 'IQPatternEvent' ) ;
    public final void rule__IQPatternEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2848:1: ( ( 'IQPatternEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2849:1: ( 'IQPatternEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2849:1: ( 'IQPatternEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2850:1: 'IQPatternEvent'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternEventKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5848); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2863:1: rule__IQPatternEvent__Group__1 : rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 ;
    public final void rule__IQPatternEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2867:1: ( rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2868:2: rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15879);
            rule__IQPatternEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15882);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2875:1: rule__IQPatternEvent__Group__1__Impl : ( ( rule__IQPatternEvent__NameAssignment_1 ) ) ;
    public final void rule__IQPatternEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2879:1: ( ( ( rule__IQPatternEvent__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2880:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2880:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2881:1: ( rule__IQPatternEvent__NameAssignment_1 )
            {
             before(grammarAccess.getIQPatternEventAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2882:1: ( rule__IQPatternEvent__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2882:2: rule__IQPatternEvent__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5909);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2892:1: rule__IQPatternEvent__Group__2 : rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 ;
    public final void rule__IQPatternEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2896:1: ( rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2897:2: rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25939);
            rule__IQPatternEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25942);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2904:1: rule__IQPatternEvent__Group__2__Impl : ( '()' ) ;
    public final void rule__IQPatternEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2908:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2909:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2909:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2910:1: '()'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftParenthesisRightParenthesisKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5970); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2923:1: rule__IQPatternEvent__Group__3 : rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 ;
    public final void rule__IQPatternEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2927:1: ( rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2928:2: rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__36001);
            rule__IQPatternEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__36004);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2935:1: rule__IQPatternEvent__Group__3__Impl : ( '{' ) ;
    public final void rule__IQPatternEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2939:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2940:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2940:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2941:1: '{'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl6032); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2954:1: rule__IQPatternEvent__Group__4 : rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 ;
    public final void rule__IQPatternEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2958:1: ( rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2959:2: rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__46063);
            rule__IQPatternEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__46066);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2966:1: rule__IQPatternEvent__Group__4__Impl : ( 'IQPatternRef' ) ;
    public final void rule__IQPatternEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2970:1: ( ( 'IQPatternRef' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2971:1: ( 'IQPatternRef' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2971:1: ( 'IQPatternRef' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2972:1: 'IQPatternRef'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternRefKeyword_4()); 
            match(input,41,FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl6094); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2985:1: rule__IQPatternEvent__Group__5 : rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 ;
    public final void rule__IQPatternEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2989:1: ( rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2990:2: rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__56125);
            rule__IQPatternEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__56128);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2997:1: rule__IQPatternEvent__Group__5__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3001:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3002:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3002:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3003:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_5()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl6156); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3016:1: rule__IQPatternEvent__Group__6 : rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 ;
    public final void rule__IQPatternEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3020:1: ( rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3021:2: rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__66187);
            rule__IQPatternEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__66190);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3028:1: rule__IQPatternEvent__Group__6__Impl : ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) ;
    public final void rule__IQPatternEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3032:1: ( ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3033:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3033:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3034:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternAssignment_6()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3035:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3035:2: rule__IQPatternEvent__IqpatternAssignment_6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl6217);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3045:1: rule__IQPatternEvent__Group__7 : rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 ;
    public final void rule__IQPatternEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3049:1: ( rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3050:2: rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__76247);
            rule__IQPatternEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__76250);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3057:1: rule__IQPatternEvent__Group__7__Impl : ( 'ChangeType' ) ;
    public final void rule__IQPatternEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3061:1: ( ( 'ChangeType' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3062:1: ( 'ChangeType' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3062:1: ( 'ChangeType' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3063:1: 'ChangeType'
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeKeyword_7()); 
            match(input,42,FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl6278); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3076:1: rule__IQPatternEvent__Group__8 : rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 ;
    public final void rule__IQPatternEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3080:1: ( rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3081:2: rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__86309);
            rule__IQPatternEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__86312);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3088:1: rule__IQPatternEvent__Group__8__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3092:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3093:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3093:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3094:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl6340); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3107:1: rule__IQPatternEvent__Group__9 : rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 ;
    public final void rule__IQPatternEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3111:1: ( rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3112:2: rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__96371);
            rule__IQPatternEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__96374);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3119:1: rule__IQPatternEvent__Group__9__Impl : ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) ;
    public final void rule__IQPatternEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3123:1: ( ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3124:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3124:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3125:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeAssignment_9()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3126:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3126:2: rule__IQPatternEvent__ChangeTypeAssignment_9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl6401);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3136:1: rule__IQPatternEvent__Group__10 : rule__IQPatternEvent__Group__10__Impl ;
    public final void rule__IQPatternEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3140:1: ( rule__IQPatternEvent__Group__10__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3141:2: rule__IQPatternEvent__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__106431);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3147:1: rule__IQPatternEvent__Group__10__Impl : ( '}' ) ;
    public final void rule__IQPatternEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3151:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3152:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3152:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3153:1: '}'
            {
             before(grammarAccess.getIQPatternEventAccess().getRightCurlyBracketKeyword_10()); 
            match(input,33,FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl6459); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3188:1: rule__ComplexEvent__Group__0 : rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 ;
    public final void rule__ComplexEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3192:1: ( rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3193:2: rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06512);
            rule__ComplexEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06515);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3200:1: rule__ComplexEvent__Group__0__Impl : ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__ComplexEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3204:1: ( ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3205:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3205:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3206:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3207:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=46 && LA20_0<=48)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3207:2: rule__ComplexEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6542);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3217:1: rule__ComplexEvent__Group__1 : rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 ;
    public final void rule__ComplexEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3221:1: ( rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3222:2: rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16573);
            rule__ComplexEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16576);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3229:1: rule__ComplexEvent__Group__1__Impl : ( 'ComplexEvent' ) ;
    public final void rule__ComplexEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3233:1: ( ( 'ComplexEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3234:1: ( 'ComplexEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3234:1: ( 'ComplexEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3235:1: 'ComplexEvent'
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventKeyword_1()); 
            match(input,43,FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6604); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3248:1: rule__ComplexEvent__Group__2 : rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 ;
    public final void rule__ComplexEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3252:1: ( rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3253:2: rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26635);
            rule__ComplexEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26638);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3260:1: rule__ComplexEvent__Group__2__Impl : ( ( rule__ComplexEvent__NameAssignment_2 ) ) ;
    public final void rule__ComplexEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3264:1: ( ( ( rule__ComplexEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3265:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3265:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3266:1: ( rule__ComplexEvent__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3267:1: ( rule__ComplexEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3267:2: rule__ComplexEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6665);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3277:1: rule__ComplexEvent__Group__3 : rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 ;
    public final void rule__ComplexEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3281:1: ( rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3282:2: rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36695);
            rule__ComplexEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36698);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3289:1: rule__ComplexEvent__Group__3__Impl : ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) ;
    public final void rule__ComplexEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3293:1: ( ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3294:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3294:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3295:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            {
             before(grammarAccess.getComplexEventAccess().getParamlistAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3296:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3296:2: rule__ComplexEvent__ParamlistAssignment_3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6725);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3306:1: rule__ComplexEvent__Group__4 : rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 ;
    public final void rule__ComplexEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3310:1: ( rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3311:2: rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46755);
            rule__ComplexEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46758);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3318:1: rule__ComplexEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__ComplexEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3322:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3323:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3323:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3324:1: '{'
            {
             before(grammarAccess.getComplexEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6786); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3337:1: rule__ComplexEvent__Group__5 : rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6 ;
    public final void rule__ComplexEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3341:1: ( rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3342:2: rule__ComplexEvent__Group__5__Impl rule__ComplexEvent__Group__6
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56817);
            rule__ComplexEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__6_in_rule__ComplexEvent__Group__56820);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3349:1: rule__ComplexEvent__Group__5__Impl : ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* ) ;
    public final void rule__ComplexEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3353:1: ( ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3354:1: ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3354:1: ( ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3355:1: ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )*
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventExpressionsAssignment_5()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3356:1: ( rule__ComplexEvent__ComplexEventExpressionsAssignment_5 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3356:2: rule__ComplexEvent__ComplexEventExpressionsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__ComplexEvent__ComplexEventExpressionsAssignment_5_in_rule__ComplexEvent__Group__5__Impl6847);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3366:1: rule__ComplexEvent__Group__6 : rule__ComplexEvent__Group__6__Impl ;
    public final void rule__ComplexEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3370:1: ( rule__ComplexEvent__Group__6__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3371:2: rule__ComplexEvent__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__6__Impl_in_rule__ComplexEvent__Group__66878);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3377:1: rule__ComplexEvent__Group__6__Impl : ( '}' ) ;
    public final void rule__ComplexEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3381:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3382:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3382:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3383:1: '}'
            {
             before(grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_6()); 
            match(input,33,FOLLOW_33_in_rule__ComplexEvent__Group__6__Impl6906); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3410:1: rule__CEParamlist__Group__0 : rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 ;
    public final void rule__CEParamlist__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3414:1: ( rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3415:2: rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06951);
            rule__CEParamlist__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06954);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3422:1: rule__CEParamlist__Group__0__Impl : ( () ) ;
    public final void rule__CEParamlist__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3426:1: ( ( () ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3427:1: ( () )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3427:1: ( () )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3428:1: ()
            {
             before(grammarAccess.getCEParamlistAccess().getCEParamlistAction_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3429:1: ()
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3431:1: 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3441:1: rule__CEParamlist__Group__1 : rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 ;
    public final void rule__CEParamlist__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3445:1: ( rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3446:2: rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__17012);
            rule__CEParamlist__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__17015);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3453:1: rule__CEParamlist__Group__1__Impl : ( '(' ) ;
    public final void rule__CEParamlist__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3457:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3458:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3458:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3459:1: '('
            {
             before(grammarAccess.getCEParamlistAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__CEParamlist__Group__1__Impl7043); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3472:1: rule__CEParamlist__Group__2 : rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 ;
    public final void rule__CEParamlist__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3476:1: ( rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3477:2: rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__27074);
            rule__CEParamlist__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__27077);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3484:1: rule__CEParamlist__Group__2__Impl : ( ( rule__CEParamlist__ParamsAssignment_2 )* ) ;
    public final void rule__CEParamlist__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3488:1: ( ( ( rule__CEParamlist__ParamsAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3489:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3489:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3490:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            {
             before(grammarAccess.getCEParamlistAccess().getParamsAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3491:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3491:2: rule__CEParamlist__ParamsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl7104);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3501:1: rule__CEParamlist__Group__3 : rule__CEParamlist__Group__3__Impl ;
    public final void rule__CEParamlist__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3505:1: ( rule__CEParamlist__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3506:2: rule__CEParamlist__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__37135);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3512:1: rule__CEParamlist__Group__3__Impl : ( ')' ) ;
    public final void rule__CEParamlist__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3516:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3517:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3517:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3518:1: ')'
            {
             before(grammarAccess.getCEParamlistAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__CEParamlist__Group__3__Impl7163); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3539:1: rule__EventParamWithType__Group__0 : rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1 ;
    public final void rule__EventParamWithType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3543:1: ( rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3544:2: rule__EventParamWithType__Group__0__Impl rule__EventParamWithType__Group__1
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__0__Impl_in_rule__EventParamWithType__Group__07202);
            rule__EventParamWithType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventParamWithType__Group__1_in_rule__EventParamWithType__Group__07205);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3551:1: rule__EventParamWithType__Group__0__Impl : ( ( rule__EventParamWithType__NameAssignment_0 ) ) ;
    public final void rule__EventParamWithType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3555:1: ( ( ( rule__EventParamWithType__NameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3556:1: ( ( rule__EventParamWithType__NameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3556:1: ( ( rule__EventParamWithType__NameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3557:1: ( rule__EventParamWithType__NameAssignment_0 )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3558:1: ( rule__EventParamWithType__NameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3558:2: rule__EventParamWithType__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__EventParamWithType__NameAssignment_0_in_rule__EventParamWithType__Group__0__Impl7232);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3568:1: rule__EventParamWithType__Group__1 : rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2 ;
    public final void rule__EventParamWithType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3572:1: ( rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3573:2: rule__EventParamWithType__Group__1__Impl rule__EventParamWithType__Group__2
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__1__Impl_in_rule__EventParamWithType__Group__17262);
            rule__EventParamWithType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventParamWithType__Group__2_in_rule__EventParamWithType__Group__17265);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3580:1: rule__EventParamWithType__Group__1__Impl : ( ':' ) ;
    public final void rule__EventParamWithType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3584:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3585:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3585:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3586:1: ':'
            {
             before(grammarAccess.getEventParamWithTypeAccess().getColonKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__EventParamWithType__Group__1__Impl7293); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3599:1: rule__EventParamWithType__Group__2 : rule__EventParamWithType__Group__2__Impl ;
    public final void rule__EventParamWithType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3603:1: ( rule__EventParamWithType__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3604:2: rule__EventParamWithType__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__EventParamWithType__Group__2__Impl_in_rule__EventParamWithType__Group__27324);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3610:1: rule__EventParamWithType__Group__2__Impl : ( ( rule__EventParamWithType__TypeAssignment_2 ) ) ;
    public final void rule__EventParamWithType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3614:1: ( ( ( rule__EventParamWithType__TypeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3615:1: ( ( rule__EventParamWithType__TypeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3615:1: ( ( rule__EventParamWithType__TypeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3616:1: ( rule__EventParamWithType__TypeAssignment_2 )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3617:1: ( rule__EventParamWithType__TypeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3617:2: rule__EventParamWithType__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__EventParamWithType__TypeAssignment_2_in_rule__EventParamWithType__Group__2__Impl7351);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3633:1: rule__ParameterFilter__Group__0 : rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 ;
    public final void rule__ParameterFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3637:1: ( rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3638:2: rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__07387);
            rule__ParameterFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__07390);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3645:1: rule__ParameterFilter__Group__0__Impl : ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) ;
    public final void rule__ParameterFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3649:1: ( ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3650:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3650:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3651:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3652:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3652:2: rule__ParameterFilter__AttributeNameAssignment_0
            {
            pushFollow(FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl7417);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3662:1: rule__ParameterFilter__Group__1 : rule__ParameterFilter__Group__1__Impl ;
    public final void rule__ParameterFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3666:1: ( rule__ParameterFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3667:2: rule__ParameterFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__17447);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3673:1: rule__ParameterFilter__Group__1__Impl : ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) ;
    public final void rule__ParameterFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3677:1: ( ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3678:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3678:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3679:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3680:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3680:2: rule__ParameterFilter__ParamFilterRuleAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl7474);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3694:1: rule__ContextAnnotation__Group__0 : rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 ;
    public final void rule__ContextAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3698:1: ( rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3699:2: rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__07508);
            rule__ContextAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__07511);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3706:1: rule__ContextAnnotation__Group__0__Impl : ( '@Context' ) ;
    public final void rule__ContextAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3710:1: ( ( '@Context' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3711:1: ( '@Context' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3711:1: ( '@Context' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3712:1: '@Context'
            {
             before(grammarAccess.getContextAnnotationAccess().getContextKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7539); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3725:1: rule__ContextAnnotation__Group__1 : rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 ;
    public final void rule__ContextAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3729:1: ( rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3730:2: rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17570);
            rule__ContextAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17573);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3737:1: rule__ContextAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__ContextAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3741:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3742:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3742:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3743:1: '('
            {
             before(grammarAccess.getContextAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7601); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3756:1: rule__ContextAnnotation__Group__2 : rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 ;
    public final void rule__ContextAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3760:1: ( rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3761:2: rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27632);
            rule__ContextAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27635);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3768:1: rule__ContextAnnotation__Group__2__Impl : ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) ;
    public final void rule__ContextAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3772:1: ( ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3773:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3773:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3774:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            {
             before(grammarAccess.getContextAnnotationAccess().getContextAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3775:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3775:2: rule__ContextAnnotation__ContextAssignment_2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7662);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3785:1: rule__ContextAnnotation__Group__3 : rule__ContextAnnotation__Group__3__Impl ;
    public final void rule__ContextAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3789:1: ( rule__ContextAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3790:2: rule__ContextAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37692);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3796:1: rule__ContextAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__ContextAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3800:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3801:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3801:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3802:1: ')'
            {
             before(grammarAccess.getContextAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7720); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3823:1: rule__SamplingAnnotation__Group__0 : rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 ;
    public final void rule__SamplingAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3827:1: ( rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3828:2: rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07759);
            rule__SamplingAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07762);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3835:1: rule__SamplingAnnotation__Group__0__Impl : ( '@SamplingTime' ) ;
    public final void rule__SamplingAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3839:1: ( ( '@SamplingTime' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3840:1: ( '@SamplingTime' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3840:1: ( '@SamplingTime' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3841:1: '@SamplingTime'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingTimeKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7790); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3854:1: rule__SamplingAnnotation__Group__1 : rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 ;
    public final void rule__SamplingAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3858:1: ( rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3859:2: rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17821);
            rule__SamplingAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17824);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3866:1: rule__SamplingAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__SamplingAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3870:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3871:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3871:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3872:1: '('
            {
             before(grammarAccess.getSamplingAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7852); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3885:1: rule__SamplingAnnotation__Group__2 : rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 ;
    public final void rule__SamplingAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3889:1: ( rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3890:2: rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27883);
            rule__SamplingAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27886);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3897:1: rule__SamplingAnnotation__Group__2__Impl : ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) ;
    public final void rule__SamplingAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3901:1: ( ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3902:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3902:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3903:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3904:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3904:2: rule__SamplingAnnotation__SamplingAssignment_2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7913);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3914:1: rule__SamplingAnnotation__Group__3 : rule__SamplingAnnotation__Group__3__Impl ;
    public final void rule__SamplingAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3918:1: ( rule__SamplingAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3919:2: rule__SamplingAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37943);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3925:1: rule__SamplingAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__SamplingAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3929:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3930:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3930:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3931:1: ')'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7971); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3952:1: rule__PriorityAnnotation__Group__0 : rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 ;
    public final void rule__PriorityAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3956:1: ( rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3957:2: rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__08010);
            rule__PriorityAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__08013);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3964:1: rule__PriorityAnnotation__Group__0__Impl : ( '@Priority' ) ;
    public final void rule__PriorityAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3968:1: ( ( '@Priority' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3969:1: ( '@Priority' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3969:1: ( '@Priority' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3970:1: '@Priority'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl8041); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3983:1: rule__PriorityAnnotation__Group__1 : rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 ;
    public final void rule__PriorityAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3987:1: ( rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3988:2: rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__18072);
            rule__PriorityAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__18075);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3995:1: rule__PriorityAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__PriorityAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3999:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4000:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4000:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4001:1: '('
            {
             before(grammarAccess.getPriorityAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl8103); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4014:1: rule__PriorityAnnotation__Group__2 : rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 ;
    public final void rule__PriorityAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4018:1: ( rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4019:2: rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__28134);
            rule__PriorityAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__28137);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4026:1: rule__PriorityAnnotation__Group__2__Impl : ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) ;
    public final void rule__PriorityAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4030:1: ( ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4031:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4031:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4032:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4033:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4033:2: rule__PriorityAnnotation__PriorityAssignment_2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl8164);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4043:1: rule__PriorityAnnotation__Group__3 : rule__PriorityAnnotation__Group__3__Impl ;
    public final void rule__PriorityAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4047:1: ( rule__PriorityAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4048:2: rule__PriorityAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__38194);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4054:1: rule__PriorityAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__PriorityAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4058:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4059:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4059:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4060:1: ')'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl8222); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4081:1: rule__RangeFilter__Group__0 : rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 ;
    public final void rule__RangeFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4085:1: ( rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4086:2: rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__08261);
            rule__RangeFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__08264);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4093:1: rule__RangeFilter__Group__0__Impl : ( ( rule__RangeFilter__NegAssignment_0 )? ) ;
    public final void rule__RangeFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4097:1: ( ( ( rule__RangeFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4098:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4098:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4099:1: ( rule__RangeFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getRangeFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4100:1: ( rule__RangeFilter__NegAssignment_0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==11) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4100:2: rule__RangeFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl8291);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4110:1: rule__RangeFilter__Group__1 : rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 ;
    public final void rule__RangeFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4114:1: ( rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4115:2: rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__18322);
            rule__RangeFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__18325);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4122:1: rule__RangeFilter__Group__1__Impl : ( 'in' ) ;
    public final void rule__RangeFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4126:1: ( ( 'in' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4127:1: ( 'in' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4127:1: ( 'in' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4128:1: 'in'
            {
             before(grammarAccess.getRangeFilterAccess().getInKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__RangeFilter__Group__1__Impl8353); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4141:1: rule__RangeFilter__Group__2 : rule__RangeFilter__Group__2__Impl ;
    public final void rule__RangeFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4145:1: ( rule__RangeFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4146:2: rule__RangeFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__28384);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4152:1: rule__RangeFilter__Group__2__Impl : ( ( rule__RangeFilter__RangeAssignment_2 ) ) ;
    public final void rule__RangeFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4156:1: ( ( ( rule__RangeFilter__RangeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4157:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4157:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4158:1: ( rule__RangeFilter__RangeAssignment_2 )
            {
             before(grammarAccess.getRangeFilterAccess().getRangeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4159:1: ( rule__RangeFilter__RangeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4159:2: rule__RangeFilter__RangeAssignment_2
            {
            pushFollow(FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl8411);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4175:1: rule__OpenOpen__Group__0 : rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 ;
    public final void rule__OpenOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4179:1: ( rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4180:2: rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__08447);
            rule__OpenOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__08450);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4187:1: rule__OpenOpen__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4191:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4192:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4192:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4193:1: '('
            {
             before(grammarAccess.getOpenOpenAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenOpen__Group__0__Impl8478); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4206:1: rule__OpenOpen__Group__1 : rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 ;
    public final void rule__OpenOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4210:1: ( rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4211:2: rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__18509);
            rule__OpenOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__18512);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4218:1: rule__OpenOpen__Group__1__Impl : ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4222:1: ( ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4223:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4223:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4224:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4225:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4225:2: rule__OpenOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8539);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4235:1: rule__OpenOpen__Group__2 : rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 ;
    public final void rule__OpenOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4239:1: ( rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4240:2: rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28569);
            rule__OpenOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28572);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4247:1: rule__OpenOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4251:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4252:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4252:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4253:1: ','
            {
             before(grammarAccess.getOpenOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8600); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4266:1: rule__OpenOpen__Group__3 : rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 ;
    public final void rule__OpenOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4270:1: ( rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4271:2: rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38631);
            rule__OpenOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38634);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4278:1: rule__OpenOpen__Group__3__Impl : ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4282:1: ( ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4283:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4283:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4284:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4285:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4285:2: rule__OpenOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8661);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4295:1: rule__OpenOpen__Group__4 : rule__OpenOpen__Group__4__Impl ;
    public final void rule__OpenOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4299:1: ( rule__OpenOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4300:2: rule__OpenOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48691);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4306:1: rule__OpenOpen__Group__4__Impl : ( ')' ) ;
    public final void rule__OpenOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4310:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4311:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4311:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4312:1: ')'
            {
             before(grammarAccess.getOpenOpenAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8719); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4335:1: rule__OpenClosed__Group__0 : rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 ;
    public final void rule__OpenClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4339:1: ( rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4340:2: rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08760);
            rule__OpenClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08763);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4347:1: rule__OpenClosed__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4351:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4352:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4352:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4353:1: '('
            {
             before(grammarAccess.getOpenClosedAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8791); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4366:1: rule__OpenClosed__Group__1 : rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 ;
    public final void rule__OpenClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4370:1: ( rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4371:2: rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18822);
            rule__OpenClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18825);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4378:1: rule__OpenClosed__Group__1__Impl : ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4382:1: ( ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4383:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4383:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4384:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4385:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4385:2: rule__OpenClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8852);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4395:1: rule__OpenClosed__Group__2 : rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 ;
    public final void rule__OpenClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4399:1: ( rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4400:2: rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28882);
            rule__OpenClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28885);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4407:1: rule__OpenClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4411:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4412:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4412:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4413:1: ','
            {
             before(grammarAccess.getOpenClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8913); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4426:1: rule__OpenClosed__Group__3 : rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 ;
    public final void rule__OpenClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4430:1: ( rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4431:2: rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38944);
            rule__OpenClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38947);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4438:1: rule__OpenClosed__Group__3__Impl : ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4442:1: ( ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4443:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4443:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4444:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4445:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4445:2: rule__OpenClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8974);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4455:1: rule__OpenClosed__Group__4 : rule__OpenClosed__Group__4__Impl ;
    public final void rule__OpenClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4459:1: ( rule__OpenClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4460:2: rule__OpenClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__49004);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4466:1: rule__OpenClosed__Group__4__Impl : ( ']' ) ;
    public final void rule__OpenClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4470:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4471:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4471:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4472:1: ']'
            {
             before(grammarAccess.getOpenClosedAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__OpenClosed__Group__4__Impl9032); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4495:1: rule__ClosedClosed__Group__0 : rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 ;
    public final void rule__ClosedClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4499:1: ( rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4500:2: rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__09073);
            rule__ClosedClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__09076);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4507:1: rule__ClosedClosed__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4511:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4512:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4512:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4513:1: '['
            {
             before(grammarAccess.getClosedClosedAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl9104); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4526:1: rule__ClosedClosed__Group__1 : rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 ;
    public final void rule__ClosedClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4530:1: ( rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4531:2: rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__19135);
            rule__ClosedClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__19138);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4538:1: rule__ClosedClosed__Group__1__Impl : ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4542:1: ( ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4543:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4543:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4544:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4545:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4545:2: rule__ClosedClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl9165);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4555:1: rule__ClosedClosed__Group__2 : rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 ;
    public final void rule__ClosedClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4559:1: ( rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4560:2: rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__29195);
            rule__ClosedClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__29198);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4567:1: rule__ClosedClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4571:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4572:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4572:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4573:1: ','
            {
             before(grammarAccess.getClosedClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl9226); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4586:1: rule__ClosedClosed__Group__3 : rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 ;
    public final void rule__ClosedClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4590:1: ( rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4591:2: rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__39257);
            rule__ClosedClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__39260);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4598:1: rule__ClosedClosed__Group__3__Impl : ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4602:1: ( ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4603:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4603:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4604:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4605:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4605:2: rule__ClosedClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl9287);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4615:1: rule__ClosedClosed__Group__4 : rule__ClosedClosed__Group__4__Impl ;
    public final void rule__ClosedClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4619:1: ( rule__ClosedClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4620:2: rule__ClosedClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__49317);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4626:1: rule__ClosedClosed__Group__4__Impl : ( ')' ) ;
    public final void rule__ClosedClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4630:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4631:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4631:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4632:1: ')'
            {
             before(grammarAccess.getClosedClosedAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl9345); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4655:1: rule__ClosedOpen__Group__0 : rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 ;
    public final void rule__ClosedOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4659:1: ( rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4660:2: rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__09386);
            rule__ClosedOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__09389);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4667:1: rule__ClosedOpen__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4671:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4672:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4672:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4673:1: '['
            {
             before(grammarAccess.getClosedOpenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl9417); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4686:1: rule__ClosedOpen__Group__1 : rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 ;
    public final void rule__ClosedOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4690:1: ( rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4691:2: rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__19448);
            rule__ClosedOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__19451);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4698:1: rule__ClosedOpen__Group__1__Impl : ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4702:1: ( ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4703:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4703:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4704:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4705:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4705:2: rule__ClosedOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl9478);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4715:1: rule__ClosedOpen__Group__2 : rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 ;
    public final void rule__ClosedOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4719:1: ( rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4720:2: rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__29508);
            rule__ClosedOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__29511);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4727:1: rule__ClosedOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4731:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4732:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4732:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4733:1: ','
            {
             before(grammarAccess.getClosedOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9539); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4746:1: rule__ClosedOpen__Group__3 : rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 ;
    public final void rule__ClosedOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4750:1: ( rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4751:2: rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39570);
            rule__ClosedOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39573);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4758:1: rule__ClosedOpen__Group__3__Impl : ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4762:1: ( ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4763:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4763:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4764:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4765:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4765:2: rule__ClosedOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9600);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4775:1: rule__ClosedOpen__Group__4 : rule__ClosedOpen__Group__4__Impl ;
    public final void rule__ClosedOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4779:1: ( rule__ClosedOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4780:2: rule__ClosedOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49630);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4786:1: rule__ClosedOpen__Group__4__Impl : ( ']' ) ;
    public final void rule__ClosedOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4790:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4791:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4791:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4792:1: ']'
            {
             before(grammarAccess.getClosedOpenAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9658); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4815:1: rule__NumericFilter__Group__0 : rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 ;
    public final void rule__NumericFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4819:1: ( rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4820:2: rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09699);
            rule__NumericFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09702);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4827:1: rule__NumericFilter__Group__0__Impl : ( ( rule__NumericFilter__OperatorAssignment_0 ) ) ;
    public final void rule__NumericFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4831:1: ( ( ( rule__NumericFilter__OperatorAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4832:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4832:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4833:1: ( rule__NumericFilter__OperatorAssignment_0 )
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4834:1: ( rule__NumericFilter__OperatorAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4834:2: rule__NumericFilter__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9729);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4844:1: rule__NumericFilter__Group__1 : rule__NumericFilter__Group__1__Impl ;
    public final void rule__NumericFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4848:1: ( rule__NumericFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4849:2: rule__NumericFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19759);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4855:1: rule__NumericFilter__Group__1__Impl : ( ( rule__NumericFilter__ValueAssignment_1 ) ) ;
    public final void rule__NumericFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4859:1: ( ( ( rule__NumericFilter__ValueAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4860:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4860:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4861:1: ( rule__NumericFilter__ValueAssignment_1 )
            {
             before(grammarAccess.getNumericFilterAccess().getValueAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4862:1: ( rule__NumericFilter__ValueAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4862:2: rule__NumericFilter__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9786);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4876:1: rule__LiteralFilter__Group__0 : rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 ;
    public final void rule__LiteralFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4880:1: ( rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4881:2: rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09820);
            rule__LiteralFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09823);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4888:1: rule__LiteralFilter__Group__0__Impl : ( ( rule__LiteralFilter__NegAssignment_0 )? ) ;
    public final void rule__LiteralFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4892:1: ( ( ( rule__LiteralFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4893:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4893:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4894:1: ( rule__LiteralFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getLiteralFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4895:1: ( rule__LiteralFilter__NegAssignment_0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==11) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4895:2: rule__LiteralFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9850);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4905:1: rule__LiteralFilter__Group__1 : rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 ;
    public final void rule__LiteralFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4909:1: ( rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4910:2: rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19881);
            rule__LiteralFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19884);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4917:1: rule__LiteralFilter__Group__1__Impl : ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) ;
    public final void rule__LiteralFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4921:1: ( ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4922:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4922:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4923:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:2: rule__LiteralFilter__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9911);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4934:1: rule__LiteralFilter__Group__2 : rule__LiteralFilter__Group__2__Impl ;
    public final void rule__LiteralFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4938:1: ( rule__LiteralFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4939:2: rule__LiteralFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29941);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4945:1: rule__LiteralFilter__Group__2__Impl : ( ( rule__LiteralFilter__ValueAssignment_2 ) ) ;
    public final void rule__LiteralFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4949:1: ( ( ( rule__LiteralFilter__ValueAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4950:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4950:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4951:1: ( rule__LiteralFilter__ValueAssignment_2 )
            {
             before(grammarAccess.getLiteralFilterAccess().getValueAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4952:1: ( rule__LiteralFilter__ValueAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4952:2: rule__LiteralFilter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9968);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4968:1: rule__FollowsExpression__Group__0 : rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1 ;
    public final void rule__FollowsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4972:1: ( rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4973:2: rule__FollowsExpression__Group__0__Impl rule__FollowsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__0__Impl_in_rule__FollowsExpression__Group__010004);
            rule__FollowsExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsExpression__Group__1_in_rule__FollowsExpression__Group__010007);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4980:1: rule__FollowsExpression__Group__0__Impl : ( ( rule__FollowsExpression__FirstEventAssignment_0 ) ) ;
    public final void rule__FollowsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4984:1: ( ( ( rule__FollowsExpression__FirstEventAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4985:1: ( ( rule__FollowsExpression__FirstEventAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4985:1: ( ( rule__FollowsExpression__FirstEventAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4986:1: ( rule__FollowsExpression__FirstEventAssignment_0 )
            {
             before(grammarAccess.getFollowsExpressionAccess().getFirstEventAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4987:1: ( rule__FollowsExpression__FirstEventAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4987:2: rule__FollowsExpression__FirstEventAssignment_0
            {
            pushFollow(FOLLOW_rule__FollowsExpression__FirstEventAssignment_0_in_rule__FollowsExpression__Group__0__Impl10034);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4997:1: rule__FollowsExpression__Group__1 : rule__FollowsExpression__Group__1__Impl ;
    public final void rule__FollowsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5001:1: ( rule__FollowsExpression__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5002:2: rule__FollowsExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FollowsExpression__Group__1__Impl_in_rule__FollowsExpression__Group__110064);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5008:1: rule__FollowsExpression__Group__1__Impl : ( ( rule__FollowsExpression__EventsAssignment_1 )* ) ;
    public final void rule__FollowsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5012:1: ( ( ( rule__FollowsExpression__EventsAssignment_1 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5013:1: ( ( rule__FollowsExpression__EventsAssignment_1 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5013:1: ( ( rule__FollowsExpression__EventsAssignment_1 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5014:1: ( rule__FollowsExpression__EventsAssignment_1 )*
            {
             before(grammarAccess.getFollowsExpressionAccess().getEventsAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5015:1: ( rule__FollowsExpression__EventsAssignment_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=53 && LA25_0<=54)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5015:2: rule__FollowsExpression__EventsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__FollowsExpression__EventsAssignment_1_in_rule__FollowsExpression__Group__1__Impl10091);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5029:1: rule__EventWithFollowsOperator__Group__0 : rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1 ;
    public final void rule__EventWithFollowsOperator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5033:1: ( rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5034:2: rule__EventWithFollowsOperator__Group__0__Impl rule__EventWithFollowsOperator__Group__1
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__0__Impl_in_rule__EventWithFollowsOperator__Group__010126);
            rule__EventWithFollowsOperator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__1_in_rule__EventWithFollowsOperator__Group__010129);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5041:1: rule__EventWithFollowsOperator__Group__0__Impl : ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) ) ;
    public final void rule__EventWithFollowsOperator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5045:1: ( ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5046:1: ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5046:1: ( ( rule__EventWithFollowsOperator__OperatorAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5047:1: ( rule__EventWithFollowsOperator__OperatorAssignment_0 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5048:1: ( rule__EventWithFollowsOperator__OperatorAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5048:2: rule__EventWithFollowsOperator__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__OperatorAssignment_0_in_rule__EventWithFollowsOperator__Group__0__Impl10156);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5058:1: rule__EventWithFollowsOperator__Group__1 : rule__EventWithFollowsOperator__Group__1__Impl ;
    public final void rule__EventWithFollowsOperator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5062:1: ( rule__EventWithFollowsOperator__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5063:2: rule__EventWithFollowsOperator__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__Group__1__Impl_in_rule__EventWithFollowsOperator__Group__110186);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5069:1: rule__EventWithFollowsOperator__Group__1__Impl : ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) ) ;
    public final void rule__EventWithFollowsOperator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5073:1: ( ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5074:1: ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5074:1: ( ( rule__EventWithFollowsOperator__EventAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5075:1: ( rule__EventWithFollowsOperator__EventAssignment_1 )
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getEventAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5076:1: ( rule__EventWithFollowsOperator__EventAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5076:2: rule__EventWithFollowsOperator__EventAssignment_1
            {
            pushFollow(FOLLOW_rule__EventWithFollowsOperator__EventAssignment_1_in_rule__EventWithFollowsOperator__Group__1__Impl10213);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5090:1: rule__FollowsOperatorNoTW__Group__0 : rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1 ;
    public final void rule__FollowsOperatorNoTW__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5094:1: ( rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5095:2: rule__FollowsOperatorNoTW__Group__0__Impl rule__FollowsOperatorNoTW__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__0__Impl_in_rule__FollowsOperatorNoTW__Group__010247);
            rule__FollowsOperatorNoTW__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__1_in_rule__FollowsOperatorNoTW__Group__010250);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5102:1: rule__FollowsOperatorNoTW__Group__0__Impl : ( () ) ;
    public final void rule__FollowsOperatorNoTW__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5106:1: ( ( () ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5107:1: ( () )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5107:1: ( () )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5108:1: ()
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getFollowsOperatorNoTWAction_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5109:1: ()
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5111:1: 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5121:1: rule__FollowsOperatorNoTW__Group__1 : rule__FollowsOperatorNoTW__Group__1__Impl ;
    public final void rule__FollowsOperatorNoTW__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5125:1: ( rule__FollowsOperatorNoTW__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5126:2: rule__FollowsOperatorNoTW__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__FollowsOperatorNoTW__Group__1__Impl_in_rule__FollowsOperatorNoTW__Group__110308);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5132:1: rule__FollowsOperatorNoTW__Group__1__Impl : ( '->' ) ;
    public final void rule__FollowsOperatorNoTW__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5136:1: ( ( '->' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5137:1: ( '->' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5137:1: ( '->' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5138:1: '->'
            {
             before(grammarAccess.getFollowsOperatorNoTWAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__FollowsOperatorNoTW__Group__1__Impl10336); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5155:1: rule__FollowsOperatorViaTW__Group__0 : rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1 ;
    public final void rule__FollowsOperatorViaTW__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5159:1: ( rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5160:2: rule__FollowsOperatorViaTW__Group__0__Impl rule__FollowsOperatorViaTW__Group__1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__0__Impl_in_rule__FollowsOperatorViaTW__Group__010371);
            rule__FollowsOperatorViaTW__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__1_in_rule__FollowsOperatorViaTW__Group__010374);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5167:1: rule__FollowsOperatorViaTW__Group__0__Impl : ( '-[' ) ;
    public final void rule__FollowsOperatorViaTW__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5171:1: ( ( '-[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5172:1: ( '-[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5172:1: ( '-[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5173:1: '-['
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getHyphenMinusLeftSquareBracketKeyword_0()); 
            match(input,54,FOLLOW_54_in_rule__FollowsOperatorViaTW__Group__0__Impl10402); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5186:1: rule__FollowsOperatorViaTW__Group__1 : rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2 ;
    public final void rule__FollowsOperatorViaTW__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5190:1: ( rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5191:2: rule__FollowsOperatorViaTW__Group__1__Impl rule__FollowsOperatorViaTW__Group__2
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__1__Impl_in_rule__FollowsOperatorViaTW__Group__110433);
            rule__FollowsOperatorViaTW__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__2_in_rule__FollowsOperatorViaTW__Group__110436);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5198:1: rule__FollowsOperatorViaTW__Group__1__Impl : ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) ) ;
    public final void rule__FollowsOperatorViaTW__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5202:1: ( ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5203:1: ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5203:1: ( ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5204:1: ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 )
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5205:1: ( rule__FollowsOperatorViaTW__TimewindowAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5205:2: rule__FollowsOperatorViaTW__TimewindowAssignment_1
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__TimewindowAssignment_1_in_rule__FollowsOperatorViaTW__Group__1__Impl10463);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5215:1: rule__FollowsOperatorViaTW__Group__2 : rule__FollowsOperatorViaTW__Group__2__Impl ;
    public final void rule__FollowsOperatorViaTW__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5219:1: ( rule__FollowsOperatorViaTW__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5220:2: rule__FollowsOperatorViaTW__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__FollowsOperatorViaTW__Group__2__Impl_in_rule__FollowsOperatorViaTW__Group__210493);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5226:1: rule__FollowsOperatorViaTW__Group__2__Impl : ( ']->' ) ;
    public final void rule__FollowsOperatorViaTW__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5230:1: ( ( ']->' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5231:1: ( ']->' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5231:1: ( ']->' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5232:1: ']->'
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,55,FOLLOW_55_in_rule__FollowsOperatorViaTW__Group__2__Impl10521); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5251:1: rule__EventWithMultiplicity__Group__0 : rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1 ;
    public final void rule__EventWithMultiplicity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5255:1: ( rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5256:2: rule__EventWithMultiplicity__Group__0__Impl rule__EventWithMultiplicity__Group__1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__0__Impl_in_rule__EventWithMultiplicity__Group__010558);
            rule__EventWithMultiplicity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__1_in_rule__EventWithMultiplicity__Group__010561);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5263:1: rule__EventWithMultiplicity__Group__0__Impl : ( ( rule__EventWithMultiplicity__EventAssignment_0 ) ) ;
    public final void rule__EventWithMultiplicity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5267:1: ( ( ( rule__EventWithMultiplicity__EventAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5268:1: ( ( rule__EventWithMultiplicity__EventAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5268:1: ( ( rule__EventWithMultiplicity__EventAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5269:1: ( rule__EventWithMultiplicity__EventAssignment_0 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5270:1: ( rule__EventWithMultiplicity__EventAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5270:2: rule__EventWithMultiplicity__EventAssignment_0
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__EventAssignment_0_in_rule__EventWithMultiplicity__Group__0__Impl10588);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5280:1: rule__EventWithMultiplicity__Group__1 : rule__EventWithMultiplicity__Group__1__Impl ;
    public final void rule__EventWithMultiplicity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5284:1: ( rule__EventWithMultiplicity__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5285:2: rule__EventWithMultiplicity__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group__1__Impl_in_rule__EventWithMultiplicity__Group__110618);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5291:1: rule__EventWithMultiplicity__Group__1__Impl : ( ( rule__EventWithMultiplicity__Group_1__0 )? ) ;
    public final void rule__EventWithMultiplicity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5295:1: ( ( ( rule__EventWithMultiplicity__Group_1__0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5296:1: ( ( rule__EventWithMultiplicity__Group_1__0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5296:1: ( ( rule__EventWithMultiplicity__Group_1__0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5297:1: ( rule__EventWithMultiplicity__Group_1__0 )?
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5298:1: ( rule__EventWithMultiplicity__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5298:2: rule__EventWithMultiplicity__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__0_in_rule__EventWithMultiplicity__Group__1__Impl10645);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5312:1: rule__EventWithMultiplicity__Group_1__0 : rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1 ;
    public final void rule__EventWithMultiplicity__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5316:1: ( rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5317:2: rule__EventWithMultiplicity__Group_1__0__Impl rule__EventWithMultiplicity__Group_1__1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__0__Impl_in_rule__EventWithMultiplicity__Group_1__010680);
            rule__EventWithMultiplicity__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__1_in_rule__EventWithMultiplicity__Group_1__010683);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5324:1: rule__EventWithMultiplicity__Group_1__0__Impl : ( '{' ) ;
    public final void rule__EventWithMultiplicity__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5328:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5329:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5329:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5330:1: '{'
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__EventWithMultiplicity__Group_1__0__Impl10711); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5343:1: rule__EventWithMultiplicity__Group_1__1 : rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2 ;
    public final void rule__EventWithMultiplicity__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5347:1: ( rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5348:2: rule__EventWithMultiplicity__Group_1__1__Impl rule__EventWithMultiplicity__Group_1__2
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__1__Impl_in_rule__EventWithMultiplicity__Group_1__110742);
            rule__EventWithMultiplicity__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__2_in_rule__EventWithMultiplicity__Group_1__110745);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5355:1: rule__EventWithMultiplicity__Group_1__1__Impl : ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) ) ;
    public final void rule__EventWithMultiplicity__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5359:1: ( ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5360:1: ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5360:1: ( ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5361:1: ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityAssignment_1_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5362:1: ( rule__EventWithMultiplicity__MultiplicityAssignment_1_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5362:2: rule__EventWithMultiplicity__MultiplicityAssignment_1_1
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__MultiplicityAssignment_1_1_in_rule__EventWithMultiplicity__Group_1__1__Impl10772);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5372:1: rule__EventWithMultiplicity__Group_1__2 : rule__EventWithMultiplicity__Group_1__2__Impl ;
    public final void rule__EventWithMultiplicity__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5376:1: ( rule__EventWithMultiplicity__Group_1__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5377:2: rule__EventWithMultiplicity__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__EventWithMultiplicity__Group_1__2__Impl_in_rule__EventWithMultiplicity__Group_1__210802);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5383:1: rule__EventWithMultiplicity__Group_1__2__Impl : ( '}' ) ;
    public final void rule__EventWithMultiplicity__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5387:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5388:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5388:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5389:1: '}'
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,33,FOLLOW_33_in_rule__EventWithMultiplicity__Group_1__2__Impl10830); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5409:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5413:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5414:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5414:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5415:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_110872);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5424:1: rule__PackageDeclaration__UsagesAssignment_2 : ( ruleUsage ) ;
    public final void rule__PackageDeclaration__UsagesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5428:1: ( ( ruleUsage ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5429:1: ( ruleUsage )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5429:1: ( ruleUsage )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5430:1: ruleUsage
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesUsageParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_210903);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5439:1: rule__PackageDeclaration__ModelAssignment_3 : ( ruleModel ) ;
    public final void rule__PackageDeclaration__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5443:1: ( ( ruleModel ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5444:1: ( ruleModel )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5444:1: ( ruleModel )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5445:1: ruleModel
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelModelParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_310934);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5454:1: rule__IQUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__IQUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5458:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5459:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5459:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5460:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_110965);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5469:1: rule__EventSourceUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__EventSourceUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5473:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5474:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5474:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5475:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_110996);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5484:1: rule__Model__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__Model__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5488:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5489:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5489:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5490:1: ruleAnnotations
            {
             before(grammarAccess.getModelAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_011027);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5499:1: rule__Model__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5503:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5504:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5504:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5505:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_211058); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5514:1: rule__Model__EventsAssignment_4 : ( ruleEvent ) ;
    public final void rule__Model__EventsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5518:1: ( ( ruleEvent ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5519:1: ( ruleEvent )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5519:1: ( ruleEvent )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5520:1: ruleEvent
            {
             before(grammarAccess.getModelAccess().getEventsEventParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_411089);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5529:1: rule__AtomicEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__AtomicEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5533:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5534:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5534:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5535:1: ruleAnnotations
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_011120);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5544:1: rule__AtomicEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__AtomicEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5548:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5549:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5549:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5550:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_211151); 
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


    // $ANTLR start "rule__AtomicEvent__SourceAssignment_7"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5559:1: rule__AtomicEvent__SourceAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__AtomicEvent__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5563:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5564:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5564:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5565:1: ( RULE_ID )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_7_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5566:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5567:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_711186); 
             after(grammarAccess.getAtomicEventAccess().getSourceSourceIDTerminalRuleCall_7_0_1()); 

            }

             after(grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_7_0()); 

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
    // $ANTLR end "rule__AtomicEvent__SourceAssignment_7"


    // $ANTLR start "rule__AtomicEvent__IdAssignment_10"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5578:1: rule__AtomicEvent__IdAssignment_10 : ( RULE_STRING ) ;
    public final void rule__AtomicEvent__IdAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5582:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5583:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5583:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5584:1: RULE_STRING
            {
             before(grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_10_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_1011221); 
             after(grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_10_0()); 

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
    // $ANTLR end "rule__AtomicEvent__IdAssignment_10"


    // $ANTLR start "rule__AtomicEvent__ParameterFiltersAssignment_13"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5593:1: rule__AtomicEvent__ParameterFiltersAssignment_13 : ( ruleParameterFilter ) ;
    public final void rule__AtomicEvent__ParameterFiltersAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5597:1: ( ( ruleParameterFilter ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5598:1: ( ruleParameterFilter )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5598:1: ( ruleParameterFilter )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5599:1: ruleParameterFilter
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersParameterFilterParserRuleCall_13_0()); 
            pushFollow(FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_1311252);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5608:1: rule__IQPatternEvent__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IQPatternEvent__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5612:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5613:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5613:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5614:1: RULE_ID
            {
             before(grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_111283); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5623:1: rule__IQPatternEvent__IqpatternAssignment_6 : ( ruleIQPattern ) ;
    public final void rule__IQPatternEvent__IqpatternAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5627:1: ( ( ruleIQPattern ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5628:1: ( ruleIQPattern )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5628:1: ( ruleIQPattern )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5629:1: ruleIQPattern
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternIQPatternParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleIQPattern_in_rule__IQPatternEvent__IqpatternAssignment_611314);
            ruleIQPattern();

            state._fsp--;

             after(grammarAccess.getIQPatternEventAccess().getIqpatternIQPatternParserRuleCall_6_0()); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5638:1: rule__IQPatternEvent__ChangeTypeAssignment_9 : ( ruleIQPatternChangeType ) ;
    public final void rule__IQPatternEvent__ChangeTypeAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5642:1: ( ( ruleIQPatternChangeType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5643:1: ( ruleIQPatternChangeType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5643:1: ( ruleIQPatternChangeType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5644:1: ruleIQPatternChangeType
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_911345);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5653:1: rule__ComplexEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__ComplexEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5657:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5658:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5658:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5659:1: ruleAnnotations
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_011376);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5668:1: rule__ComplexEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComplexEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5672:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5673:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5673:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5674:1: RULE_ID
            {
             before(grammarAccess.getComplexEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_211407); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5683:1: rule__ComplexEvent__ParamlistAssignment_3 : ( ruleCEParamlist ) ;
    public final void rule__ComplexEvent__ParamlistAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5687:1: ( ( ruleCEParamlist ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5688:1: ( ruleCEParamlist )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5688:1: ( ruleCEParamlist )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5689:1: ruleCEParamlist
            {
             before(grammarAccess.getComplexEventAccess().getParamlistCEParamlistParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_311438);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5698:1: rule__ComplexEvent__ComplexEventExpressionsAssignment_5 : ( ruleComplexEventExpression ) ;
    public final void rule__ComplexEvent__ComplexEventExpressionsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5702:1: ( ( ruleComplexEventExpression ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5703:1: ( ruleComplexEventExpression )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5703:1: ( ruleComplexEventExpression )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5704:1: ruleComplexEventExpression
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventExpressionsComplexEventExpressionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleComplexEventExpression_in_rule__ComplexEvent__ComplexEventExpressionsAssignment_511469);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5713:1: rule__CEParamlist__ParamsAssignment_2 : ( ruleEventParamWithType ) ;
    public final void rule__CEParamlist__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5717:1: ( ( ruleEventParamWithType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5718:1: ( ruleEventParamWithType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5718:1: ( ruleEventParamWithType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5719:1: ruleEventParamWithType
            {
             before(grammarAccess.getCEParamlistAccess().getParamsEventParamWithTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEventParamWithType_in_rule__CEParamlist__ParamsAssignment_211500);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5728:1: rule__EventParamWithType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EventParamWithType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5732:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5733:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5733:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5734:1: RULE_ID
            {
             before(grammarAccess.getEventParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventParamWithType__NameAssignment_011531); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5743:1: rule__EventParamWithType__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EventParamWithType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5747:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5748:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5748:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5749:1: ( RULE_ID )
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeEventCrossReference_2_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5750:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5751:1: RULE_ID
            {
             before(grammarAccess.getEventParamWithTypeAccess().getTypeEventIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventParamWithType__TypeAssignment_211566); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5762:1: rule__ParameterFilter__AttributeNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterFilter__AttributeNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5766:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5767:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5767:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5768:1: RULE_ID
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_011601); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5777:1: rule__ParameterFilter__ParamFilterRuleAssignment_1 : ( ruleParameterFilterRule ) ;
    public final void rule__ParameterFilter__ParamFilterRuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5781:1: ( ( ruleParameterFilterRule ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5782:1: ( ruleParameterFilterRule )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5782:1: ( ruleParameterFilterRule )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5783:1: ruleParameterFilterRule
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_111632);
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


    // $ANTLR start "rule__IQPattern__NameAssignment"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5792:1: rule__IQPattern__NameAssignment : ( RULE_ID ) ;
    public final void rule__IQPattern__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5796:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5797:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5797:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5798:1: RULE_ID
            {
             before(grammarAccess.getIQPatternAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IQPattern__NameAssignment11663); 
             after(grammarAccess.getIQPatternAccess().getNameIDTerminalRuleCall_0()); 

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
    // $ANTLR end "rule__IQPattern__NameAssignment"


    // $ANTLR start "rule__ContextAnnotation__ContextAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5807:1: rule__ContextAnnotation__ContextAssignment_2 : ( ruleContext ) ;
    public final void rule__ContextAnnotation__ContextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5811:1: ( ( ruleContext ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5812:1: ( ruleContext )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5812:1: ( ruleContext )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5813:1: ruleContext
            {
             before(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_211694);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5822:1: rule__SamplingAnnotation__SamplingAssignment_2 : ( RULE_INT ) ;
    public final void rule__SamplingAnnotation__SamplingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5826:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5827:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5827:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5828:1: RULE_INT
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_211725); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5837:1: rule__PriorityAnnotation__PriorityAssignment_2 : ( RULE_INT ) ;
    public final void rule__PriorityAnnotation__PriorityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5841:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5842:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5842:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5843:1: RULE_INT
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_211756); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5852:1: rule__RangeFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__RangeFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5856:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5857:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5857:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5858:1: ruleNegationOpartor
            {
             before(grammarAccess.getRangeFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_011787);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5867:1: rule__RangeFilter__RangeAssignment_2 : ( ruleRange ) ;
    public final void rule__RangeFilter__RangeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5871:1: ( ( ruleRange ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5872:1: ( ruleRange )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5872:1: ( ruleRange )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5873:1: ruleRange
            {
             before(grammarAccess.getRangeFilterAccess().getRangeRangeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_211818);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5882:1: rule__OpenOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5886:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5887:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5887:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5888:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_111849);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5897:1: rule__OpenOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5901:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5902:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5902:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5903:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_311880);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5912:1: rule__OpenClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5916:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5917:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5917:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5918:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_111911);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5927:1: rule__OpenClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5931:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5932:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5932:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5933:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_311942);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5942:1: rule__ClosedClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5946:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5947:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5947:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5948:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_111973);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5957:1: rule__ClosedClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5961:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5962:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5962:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5963:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_312004);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5972:1: rule__ClosedOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5976:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5977:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5977:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5978:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_112035);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5987:1: rule__ClosedOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5991:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5992:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5992:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5993:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_312066);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6002:1: rule__NumericFilter__OperatorAssignment_0 : ( ruleNumericOperator ) ;
    public final void rule__NumericFilter__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6006:1: ( ( ruleNumericOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6007:1: ( ruleNumericOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6007:1: ( ruleNumericOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6008:1: ruleNumericOperator
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_012097);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6017:1: rule__NumericFilter__ValueAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__NumericFilter__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6021:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6022:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6022:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6023:1: ruleDOUBLE
            {
             before(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_112128);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6032:1: rule__LiteralFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__LiteralFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6036:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6037:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6037:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6038:1: ruleNegationOpartor
            {
             before(grammarAccess.getLiteralFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_012159);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6047:1: rule__LiteralFilter__OperatorAssignment_1 : ( ruleLiteralOperator ) ;
    public final void rule__LiteralFilter__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6051:1: ( ( ruleLiteralOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6052:1: ( ruleLiteralOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6052:1: ( ruleLiteralOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6053:1: ruleLiteralOperator
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorLiteralOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_112190);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6062:1: rule__LiteralFilter__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LiteralFilter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6066:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6067:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6067:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6068:1: RULE_STRING
            {
             before(grammarAccess.getLiteralFilterAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_212221); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6077:1: rule__FollowsExpression__FirstEventAssignment_0 : ( ruleEventWithMultiplicity ) ;
    public final void rule__FollowsExpression__FirstEventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6081:1: ( ( ruleEventWithMultiplicity ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6082:1: ( ruleEventWithMultiplicity )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6082:1: ( ruleEventWithMultiplicity )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6083:1: ruleEventWithMultiplicity
            {
             before(grammarAccess.getFollowsExpressionAccess().getFirstEventEventWithMultiplicityParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_rule__FollowsExpression__FirstEventAssignment_012252);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6092:1: rule__FollowsExpression__EventsAssignment_1 : ( ruleEventWithFollowsOperator ) ;
    public final void rule__FollowsExpression__EventsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6096:1: ( ( ruleEventWithFollowsOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6097:1: ( ruleEventWithFollowsOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6097:1: ( ruleEventWithFollowsOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6098:1: ruleEventWithFollowsOperator
            {
             before(grammarAccess.getFollowsExpressionAccess().getEventsEventWithFollowsOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEventWithFollowsOperator_in_rule__FollowsExpression__EventsAssignment_112283);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6107:1: rule__EventWithFollowsOperator__OperatorAssignment_0 : ( ruleFollowsOperator ) ;
    public final void rule__EventWithFollowsOperator__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6111:1: ( ( ruleFollowsOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6112:1: ( ruleFollowsOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6112:1: ( ruleFollowsOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6113:1: ruleFollowsOperator
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getOperatorFollowsOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFollowsOperator_in_rule__EventWithFollowsOperator__OperatorAssignment_012314);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6122:1: rule__EventWithFollowsOperator__EventAssignment_1 : ( ruleEventWithMultiplicity ) ;
    public final void rule__EventWithFollowsOperator__EventAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6126:1: ( ( ruleEventWithMultiplicity ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6127:1: ( ruleEventWithMultiplicity )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6127:1: ( ruleEventWithMultiplicity )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6128:1: ruleEventWithMultiplicity
            {
             before(grammarAccess.getEventWithFollowsOperatorAccess().getEventEventWithMultiplicityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEventWithMultiplicity_in_rule__EventWithFollowsOperator__EventAssignment_112345);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6137:1: rule__FollowsOperatorViaTW__TimewindowAssignment_1 : ( RULE_INT ) ;
    public final void rule__FollowsOperatorViaTW__TimewindowAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6141:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6142:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6142:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6143:1: RULE_INT
            {
             before(grammarAccess.getFollowsOperatorViaTWAccess().getTimewindowINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__FollowsOperatorViaTW__TimewindowAssignment_112376); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6152:1: rule__EventWithMultiplicity__EventAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EventWithMultiplicity__EventAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6156:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6157:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6157:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6158:1: ( RULE_ID )
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeCrossReference_0_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6159:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6160:1: RULE_ID
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getEventEventParamWithTypeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EventWithMultiplicity__EventAssignment_012411); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6171:1: rule__EventWithMultiplicity__MultiplicityAssignment_1_1 : ( RULE_INT ) ;
    public final void rule__EventWithMultiplicity__MultiplicityAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6175:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6176:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6176:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:6177:1: RULE_INT
            {
             before(grammarAccess.getEventWithMultiplicityAccess().getMultiplicityINTTerminalRuleCall_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EventWithMultiplicity__MultiplicityAssignment_1_112446); 
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
            return "1250:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );";
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
        "\16\uffff\1\2\1\1\1\uffff\1\3\1\4\2\uffff";
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
            "\1\20\21\uffff\1\21\5\uffff\1\22",
            "\1\23",
            "",
            "",
            "\1\24",
            "",
            "",
            "\1\17\5\uffff\1\16",
            "\1\21\5\uffff\1\22"
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
            return "1350:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );";
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
    public static final BitSet FOLLOW_ruleIQPattern_in_entryRuleIQPattern1030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIQPattern1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPattern__NameAssignment_in_ruleIQPattern1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_entryRuleAnnotations1090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotations1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Annotations__Alternatives_in_ruleAnnotations1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_entryRuleContextAnnotation1150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextAnnotation1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__0_in_ruleContextAnnotation1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_entryRuleSamplingAnnotation1210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSamplingAnnotation1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__0_in_ruleSamplingAnnotation1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_entryRulePriorityAnnotation1270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePriorityAnnotation1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__0_in_rulePriorityAnnotation1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_entryRuleParameterFilterRule1330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterFilterRule1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilterRule__Alternatives_in_ruleParameterFilterRule1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_entryRuleRangeFilter1390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeFilter1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__0_in_ruleRangeFilter1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1450 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Range__Alternatives_in_ruleRange1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_entryRuleOpenOpen1510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenOpen1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__0_in_ruleOpenOpen1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_entryRuleOpenClosed1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOpenClosed1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__0_in_ruleOpenClosed1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_entryRuleClosedClosed1630 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedClosed1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__0_in_ruleClosedClosed1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_entryRuleClosedOpen1690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClosedOpen1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__0_in_ruleClosedOpen1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_entryRuleNumericFilter1750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericFilter1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__0_in_ruleNumericFilter1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_entryRuleNumericOperator1810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericOperator1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericOperator__Alternatives_in_ruleNumericOperator1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_entryRuleLiteralFilter1870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFilter1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__0_in_ruleLiteralFilter1903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_entryRuleLiteralOperator1930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralOperator1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralOperator__Alternatives_in_ruleLiteralOperator1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_entryRuleNegationOpartor1990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegationOpartor1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleNegationOpartor2024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEventExpression_in_entryRuleComplexEventExpression2052 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexEventExpression2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsExpression_in_ruleComplexEventExpression2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsExpression_in_entryRuleFollowsExpression2111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsExpression2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__0_in_ruleFollowsExpression2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithFollowsOperator_in_entryRuleEventWithFollowsOperator2171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventWithFollowsOperator2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__0_in_ruleEventWithFollowsOperator2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperator_in_entryRuleFollowsOperator2231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperator2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperator__Alternatives_in_ruleFollowsOperator2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorNoTW_in_entryRuleFollowsOperatorNoTW2291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperatorNoTW2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__0_in_ruleFollowsOperatorNoTW2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorViaTW_in_entryRuleFollowsOperatorViaTW2351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFollowsOperatorViaTW2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__0_in_ruleFollowsOperatorViaTW2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_entryRuleEventWithMultiplicity2411 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEventWithMultiplicity2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__0_in_ruleEventWithMultiplicity2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Alternatives_in_ruleContext2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives3015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralOperator__Alternatives3050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralOperator__Alternatives3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralOperator__Alternatives3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorNoTW_in_rule__FollowsOperator__Alternatives3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperatorViaTW_in_rule__FollowsOperator__Alternatives3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IQPatternChangeType__Alternatives3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__IQPatternChangeType__Alternatives3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Context__Alternatives3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Context__Alternatives3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Context__Alternatives3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__03306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__03309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__13368 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__13371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__23428 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__23431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl3458 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03554 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03797 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3883 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03918 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__04040 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__04043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__14099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__04165 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__04168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IQUsage__Group__0__Impl4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__14227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl4254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__04288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__04291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl4319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__14350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__04411 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__04414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl4441 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Model__Group__1__Impl4503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24534 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34594 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Model__Group__3__Impl4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44656 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4686 = new BitSet(new long[]{0x0001C90400000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Model__Group__5__Impl4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04788 = new BitSet(new long[]{0x0001C00400000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4818 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14849 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24911 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34971 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__45033 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__45036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl5064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__55095 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__55098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl5126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__65157 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__65160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__75219 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__75222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__SourceAssignment_7_in_rule__AtomicEvent__Group__7__Impl5249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__85279 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__85282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__95341 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__95344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl5372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__105403 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__105406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__IdAssignment_10_in_rule__AtomicEvent__Group__10__Impl5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__115463 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__115466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125525 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135587 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5619 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5631 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145664 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15879 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25939 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__36001 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__36004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl6032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__46063 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__46066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl6094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__56125 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__56128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl6156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__66187 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__66190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl6217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__76247 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__76250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl6278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__86309 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__86312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl6340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__96371 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__96374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl6401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__106431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl6459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06512 = new BitSet(new long[]{0x0001C90400000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6542 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26635 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36695 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46755 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56817 = new BitSet(new long[]{0x0000000200000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__6_in_rule__ComplexEvent__Group__56820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__ComplexEventExpressionsAssignment_5_in_rule__ComplexEvent__Group__5__Impl6847 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__6__Impl_in_rule__ComplexEvent__Group__66878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ComplexEvent__Group__6__Impl6906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06951 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__17012 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__17015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__CEParamlist__Group__1__Impl7043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__27074 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__27077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl7104 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__37135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__CEParamlist__Group__3__Impl7163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__0__Impl_in_rule__EventParamWithType__Group__07202 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__1_in_rule__EventParamWithType__Group__07205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__NameAssignment_0_in_rule__EventParamWithType__Group__0__Impl7232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__1__Impl_in_rule__EventParamWithType__Group__17262 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__2_in_rule__EventParamWithType__Group__17265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__EventParamWithType__Group__1__Impl7293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__Group__2__Impl_in_rule__EventParamWithType__Group__27324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventParamWithType__TypeAssignment_2_in_rule__EventParamWithType__Group__2__Impl7351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__07387 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__07390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__17447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl7474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__07508 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__07511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17570 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27632 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07759 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27883 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__08010 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__08013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl8041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__18072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__18075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl8103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__28134 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__28137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl8164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__38194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl8222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__08261 = new BitSet(new long[]{0x0002000000000800L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__08264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl8291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__18322 = new BitSet(new long[]{0x0010100000000000L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__18325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__RangeFilter__Group__1__Impl8353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__28384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl8411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__08447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__08450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenOpen__Group__0__Impl8478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__18509 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__18512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38631 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18822 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38944 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__49004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__OpenClosed__Group__4__Impl9032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__09073 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__09076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl9104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__19135 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__19138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl9165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__29195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__29198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl9226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__39257 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__39260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl9287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__49317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl9345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__09386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__09389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl9417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__19448 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__19451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl9478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__29508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__29511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39570 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09699 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09820 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19881 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__0__Impl_in_rule__FollowsExpression__Group__010004 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__1_in_rule__FollowsExpression__Group__010007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__FirstEventAssignment_0_in_rule__FollowsExpression__Group__0__Impl10034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__Group__1__Impl_in_rule__FollowsExpression__Group__110064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsExpression__EventsAssignment_1_in_rule__FollowsExpression__Group__1__Impl10091 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__0__Impl_in_rule__EventWithFollowsOperator__Group__010126 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__1_in_rule__EventWithFollowsOperator__Group__010129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__OperatorAssignment_0_in_rule__EventWithFollowsOperator__Group__0__Impl10156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__Group__1__Impl_in_rule__EventWithFollowsOperator__Group__110186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithFollowsOperator__EventAssignment_1_in_rule__EventWithFollowsOperator__Group__1__Impl10213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__0__Impl_in_rule__FollowsOperatorNoTW__Group__010247 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__1_in_rule__FollowsOperatorNoTW__Group__010250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorNoTW__Group__1__Impl_in_rule__FollowsOperatorNoTW__Group__110308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__FollowsOperatorNoTW__Group__1__Impl10336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__0__Impl_in_rule__FollowsOperatorViaTW__Group__010371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__1_in_rule__FollowsOperatorViaTW__Group__010374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__FollowsOperatorViaTW__Group__0__Impl10402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__1__Impl_in_rule__FollowsOperatorViaTW__Group__110433 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__2_in_rule__FollowsOperatorViaTW__Group__110436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__TimewindowAssignment_1_in_rule__FollowsOperatorViaTW__Group__1__Impl10463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FollowsOperatorViaTW__Group__2__Impl_in_rule__FollowsOperatorViaTW__Group__210493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__FollowsOperatorViaTW__Group__2__Impl10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__0__Impl_in_rule__EventWithMultiplicity__Group__010558 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__1_in_rule__EventWithMultiplicity__Group__010561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__EventAssignment_0_in_rule__EventWithMultiplicity__Group__0__Impl10588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group__1__Impl_in_rule__EventWithMultiplicity__Group__110618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__0_in_rule__EventWithMultiplicity__Group__1__Impl10645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__0__Impl_in_rule__EventWithMultiplicity__Group_1__010680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__1_in_rule__EventWithMultiplicity__Group_1__010683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__EventWithMultiplicity__Group_1__0__Impl10711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__1__Impl_in_rule__EventWithMultiplicity__Group_1__110742 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__2_in_rule__EventWithMultiplicity__Group_1__110745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__MultiplicityAssignment_1_1_in_rule__EventWithMultiplicity__Group_1__1__Impl10772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventWithMultiplicity__Group_1__2__Impl_in_rule__EventWithMultiplicity__Group_1__210802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EventWithMultiplicity__Group_1__2__Impl10830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_110872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_210903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_310934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_110965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_110996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_011027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_211058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_411089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_011120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_211151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_711186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_1011221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_1311252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_111283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPattern_in_rule__IQPatternEvent__IqpatternAssignment_611314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_911345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_011376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_211407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_311438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEventExpression_in_rule__ComplexEvent__ComplexEventExpressionsAssignment_511469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventParamWithType_in_rule__CEParamlist__ParamsAssignment_211500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventParamWithType__NameAssignment_011531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventParamWithType__TypeAssignment_211566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_011601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_111632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IQPattern__NameAssignment11663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_211694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_211725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_211756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_011787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_211818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_111849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_311880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_111911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_311942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_111973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_312004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_112035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_312066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_012097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_112128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_012159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_112190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_212221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_rule__FollowsExpression__FirstEventAssignment_012252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithFollowsOperator_in_rule__FollowsExpression__EventsAssignment_112283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFollowsOperator_in_rule__EventWithFollowsOperator__OperatorAssignment_012314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventWithMultiplicity_in_rule__EventWithFollowsOperator__EventAssignment_112345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__FollowsOperatorViaTW__TimewindowAssignment_112376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EventWithMultiplicity__EventAssignment_012411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EventWithMultiplicity__MultiplicityAssignment_1_112446 = new BitSet(new long[]{0x0000000000000002L});

}