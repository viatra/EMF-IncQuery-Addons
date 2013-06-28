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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'<'", "'=<'", "'=='", "'!='", "'>='", "'>'", "'contains'", "'startsWith'", "'endsWith'", "'FOUND'", "'LOST'", "'Chronicle'", "'Recent'", "'Unrestricted'", "'package'", "'.'", "'.*'", "'uses-incquery-patterns'", "'uses-eventsources'", "'EventModel'", "'{'", "'}'", "'AtomicEvent'", "'()'", "'source'", "':'", "'id'", "'parameterFilters'", "'IQPatternEvent'", "'IQPatternRef'", "'ChangeType'", "'ComplexEvent'", "'('", "')'", "'@Context'", "'@SamplingTime'", "'@Priority'", "'in'", "','", "']'", "'['"
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
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__18=18;
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


    // $ANTLR start "entryRuleParamWithType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:460:1: entryRuleParamWithType : ruleParamWithType EOF ;
    public final void entryRuleParamWithType() throws RecognitionException {
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:461:1: ( ruleParamWithType EOF )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:462:1: ruleParamWithType EOF
            {
             before(grammarAccess.getParamWithTypeRule()); 
            pushFollow(FOLLOW_ruleParamWithType_in_entryRuleParamWithType910);
            ruleParamWithType();

            state._fsp--;

             after(grammarAccess.getParamWithTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamWithType917); 

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
    // $ANTLR end "entryRuleParamWithType"


    // $ANTLR start "ruleParamWithType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:469:1: ruleParamWithType : ( ( rule__ParamWithType__Group__0 ) ) ;
    public final void ruleParamWithType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:473:2: ( ( ( rule__ParamWithType__Group__0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:474:1: ( ( rule__ParamWithType__Group__0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:474:1: ( ( rule__ParamWithType__Group__0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:475:1: ( rule__ParamWithType__Group__0 )
            {
             before(grammarAccess.getParamWithTypeAccess().getGroup()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:476:1: ( rule__ParamWithType__Group__0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:476:2: rule__ParamWithType__Group__0
            {
            pushFollow(FOLLOW_rule__ParamWithType__Group__0_in_ruleParamWithType943);
            rule__ParamWithType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParamWithTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParamWithType"


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


    // $ANTLR start "ruleIQPatternChangeType"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:995:1: ruleIQPatternChangeType : ( ( rule__IQPatternChangeType__Alternatives ) ) ;
    public final void ruleIQPatternChangeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:999:1: ( ( ( rule__IQPatternChangeType__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1000:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1000:1: ( ( rule__IQPatternChangeType__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1001:1: ( rule__IQPatternChangeType__Alternatives )
            {
             before(grammarAccess.getIQPatternChangeTypeAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1002:1: ( rule__IQPatternChangeType__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1002:2: rule__IQPatternChangeType__Alternatives
            {
            pushFollow(FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2062);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1014:1: ruleContext : ( ( rule__Context__Alternatives ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1018:1: ( ( ( rule__Context__Alternatives ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1019:1: ( ( rule__Context__Alternatives ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1019:1: ( ( rule__Context__Alternatives ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1020:1: ( rule__Context__Alternatives )
            {
             before(grammarAccess.getContextAccess().getAlternatives()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1021:1: ( rule__Context__Alternatives )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1021:2: rule__Context__Alternatives
            {
            pushFollow(FOLLOW_rule__Context__Alternatives_in_ruleContext2098);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1032:1: rule__Usage__Alternatives : ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) );
    public final void rule__Usage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1036:1: ( ( ruleIQUsage ) | ( ruleEventSourceUsage ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1037:1: ( ruleIQUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1037:1: ( ruleIQUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1038:1: ruleIQUsage
                    {
                     before(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2133);
                    ruleIQUsage();

                    state._fsp--;

                     after(grammarAccess.getUsageAccess().getIQUsageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1043:6: ( ruleEventSourceUsage )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1043:6: ( ruleEventSourceUsage )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1044:1: ruleEventSourceUsage
                    {
                     before(grammarAccess.getUsageAccess().getEventSourceUsageParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2150);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1054:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );
    public final void rule__Event__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1058:1: ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1059:1: ( ruleAbstractAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1059:1: ( ruleAbstractAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1060:1: ruleAbstractAtomicEvent
                    {
                     before(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2182);
                    ruleAbstractAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getEventAccess().getAbstractAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1065:6: ( ruleComplexEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1065:6: ( ruleComplexEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1066:1: ruleComplexEvent
                    {
                     before(grammarAccess.getEventAccess().getComplexEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2199);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1076:1: rule__AbstractAtomicEvent__Alternatives : ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) );
    public final void rule__AbstractAtomicEvent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1080:1: ( ( ruleAtomicEvent ) | ( ruleIQPatternEvent ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1081:1: ( ruleAtomicEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1081:1: ( ruleAtomicEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1082:1: ruleAtomicEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2231);
                    ruleAtomicEvent();

                    state._fsp--;

                     after(grammarAccess.getAbstractAtomicEventAccess().getAtomicEventParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1087:6: ( ruleIQPatternEvent )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1087:6: ( ruleIQPatternEvent )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1088:1: ruleIQPatternEvent
                    {
                     before(grammarAccess.getAbstractAtomicEventAccess().getIQPatternEventParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2248);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1098:1: rule__Annotations__Alternatives : ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) );
    public final void rule__Annotations__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1102:1: ( ( ruleContextAnnotation ) | ( ruleSamplingAnnotation ) | ( rulePriorityAnnotation ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1103:1: ( ruleContextAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1103:1: ( ruleContextAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1104:1: ruleContextAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2280);
                    ruleContextAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getContextAnnotationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1109:6: ( ruleSamplingAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1109:6: ( ruleSamplingAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1110:1: ruleSamplingAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2297);
                    ruleSamplingAnnotation();

                    state._fsp--;

                     after(grammarAccess.getAnnotationsAccess().getSamplingAnnotationParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1115:6: ( rulePriorityAnnotation )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1115:6: ( rulePriorityAnnotation )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1116:1: rulePriorityAnnotation
                    {
                     before(grammarAccess.getAnnotationsAccess().getPriorityAnnotationParserRuleCall_2()); 
                    pushFollow(FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2314);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1126:1: rule__ParameterFilterRule__Alternatives : ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) );
    public final void rule__ParameterFilterRule__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1130:1: ( ( ruleRangeFilter ) | ( ruleNumericFilter ) | ( ruleLiteralFilter ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                int LA5_1 = input.LA(2);

                if ( ((LA5_1>=18 && LA5_1<=20)) ) {
                    alt5=3;
                }
                else if ( (LA5_1==49) ) {
                    alt5=1;
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1131:1: ( ruleRangeFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1131:1: ( ruleRangeFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1132:1: ruleRangeFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2346);
                    ruleRangeFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getRangeFilterParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1137:6: ( ruleNumericFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1137:6: ( ruleNumericFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1138:1: ruleNumericFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2363);
                    ruleNumericFilter();

                    state._fsp--;

                     after(grammarAccess.getParameterFilterRuleAccess().getNumericFilterParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1143:6: ( ruleLiteralFilter )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1143:6: ( ruleLiteralFilter )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1144:1: ruleLiteralFilter
                    {
                     before(grammarAccess.getParameterFilterRuleAccess().getLiteralFilterParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2380);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1154:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );
    public final void rule__Range__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1158:1: ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1159:1: ( ruleOpenOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1159:1: ( ruleOpenOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1160:1: ruleOpenOpen
                    {
                     before(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2412);
                    ruleOpenOpen();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenOpenParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1165:6: ( ruleOpenClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1165:6: ( ruleOpenClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1166:1: ruleOpenClosed
                    {
                     before(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2429);
                    ruleOpenClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getOpenClosedParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1171:6: ( ruleClosedClosed )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1171:6: ( ruleClosedClosed )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1172:1: ruleClosedClosed
                    {
                     before(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2446);
                    ruleClosedClosed();

                    state._fsp--;

                     after(grammarAccess.getRangeAccess().getClosedClosedParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1177:6: ( ruleClosedOpen )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1177:6: ( ruleClosedOpen )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1178:1: ruleClosedOpen
                    {
                     before(grammarAccess.getRangeAccess().getClosedOpenParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2463);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1188:1: rule__NumericOperator__Alternatives : ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) );
    public final void rule__NumericOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1192:1: ( ( '<' ) | ( '=<' ) | ( '==' ) | ( '!=' ) | ( '>=' ) | ( '>' ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1193:1: ( '<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1193:1: ( '<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1194:1: '<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__NumericOperator__Alternatives2496); 
                     after(grammarAccess.getNumericOperatorAccess().getLessThanSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1201:6: ( '=<' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1201:6: ( '=<' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1202:1: '=<'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__NumericOperator__Alternatives2516); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignLessThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1209:6: ( '==' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1209:6: ( '==' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1210:1: '=='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__NumericOperator__Alternatives2536); 
                     after(grammarAccess.getNumericOperatorAccess().getEqualsSignEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1217:6: ( '!=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1217:6: ( '!=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1218:1: '!='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 
                    match(input,15,FOLLOW_15_in_rule__NumericOperator__Alternatives2556); 
                     after(grammarAccess.getNumericOperatorAccess().getExclamationMarkEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1225:6: ( '>=' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1225:6: ( '>=' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1226:1: '>='
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 
                    match(input,16,FOLLOW_16_in_rule__NumericOperator__Alternatives2576); 
                     after(grammarAccess.getNumericOperatorAccess().getGreaterThanSignEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:6: ( '>' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1233:6: ( '>' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1234:1: '>'
                    {
                     before(grammarAccess.getNumericOperatorAccess().getGreaterThanSignKeyword_5()); 
                    match(input,17,FOLLOW_17_in_rule__NumericOperator__Alternatives2596); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1246:1: rule__LiteralOperator__Alternatives : ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) );
    public final void rule__LiteralOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1250:1: ( ( 'contains' ) | ( 'startsWith' ) | ( 'endsWith' ) )
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
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1251:1: ( 'contains' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1251:1: ( 'contains' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1252:1: 'contains'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 
                    match(input,18,FOLLOW_18_in_rule__LiteralOperator__Alternatives2631); 
                     after(grammarAccess.getLiteralOperatorAccess().getContainsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1259:6: ( 'startsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1259:6: ( 'startsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1260:1: 'startsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 
                    match(input,19,FOLLOW_19_in_rule__LiteralOperator__Alternatives2651); 
                     after(grammarAccess.getLiteralOperatorAccess().getStartsWithKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1267:6: ( 'endsWith' )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1267:6: ( 'endsWith' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1268:1: 'endsWith'
                    {
                     before(grammarAccess.getLiteralOperatorAccess().getEndsWithKeyword_2()); 
                    match(input,20,FOLLOW_20_in_rule__LiteralOperator__Alternatives2671); 
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


    // $ANTLR start "rule__IQPatternChangeType__Alternatives"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1280:1: rule__IQPatternChangeType__Alternatives : ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) );
    public final void rule__IQPatternChangeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1284:1: ( ( ( 'FOUND' ) ) | ( ( 'LOST' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1285:1: ( ( 'FOUND' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1285:1: ( ( 'FOUND' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1286:1: ( 'FOUND' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1287:1: ( 'FOUND' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1287:3: 'FOUND'
                    {
                    match(input,21,FOLLOW_21_in_rule__IQPatternChangeType__Alternatives2706); 

                    }

                     after(grammarAccess.getIQPatternChangeTypeAccess().getFOUNDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1292:6: ( ( 'LOST' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1292:6: ( ( 'LOST' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1293:1: ( 'LOST' )
                    {
                     before(grammarAccess.getIQPatternChangeTypeAccess().getLOSTEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1294:1: ( 'LOST' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1294:3: 'LOST'
                    {
                    match(input,22,FOLLOW_22_in_rule__IQPatternChangeType__Alternatives2727); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1304:1: rule__Context__Alternatives : ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) );
    public final void rule__Context__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1308:1: ( ( ( 'Chronicle' ) ) | ( ( 'Recent' ) ) | ( ( 'Unrestricted' ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt10=1;
                }
                break;
            case 24:
                {
                alt10=2;
                }
                break;
            case 25:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1309:1: ( ( 'Chronicle' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1309:1: ( ( 'Chronicle' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1310:1: ( 'Chronicle' )
                    {
                     before(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:1: ( 'Chronicle' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1311:3: 'Chronicle'
                    {
                    match(input,23,FOLLOW_23_in_rule__Context__Alternatives2763); 

                    }

                     after(grammarAccess.getContextAccess().getChronicleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1316:6: ( ( 'Recent' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1316:6: ( ( 'Recent' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1317:1: ( 'Recent' )
                    {
                     before(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1318:1: ( 'Recent' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1318:3: 'Recent'
                    {
                    match(input,24,FOLLOW_24_in_rule__Context__Alternatives2784); 

                    }

                     after(grammarAccess.getContextAccess().getRecentEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1323:6: ( ( 'Unrestricted' ) )
                    {
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1323:6: ( ( 'Unrestricted' ) )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1324:1: ( 'Unrestricted' )
                    {
                     before(grammarAccess.getContextAccess().getUnrestrictedEnumLiteralDeclaration_2()); 
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1325:1: ( 'Unrestricted' )
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1325:3: 'Unrestricted'
                    {
                    match(input,25,FOLLOW_25_in_rule__Context__Alternatives2805); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1337:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1341:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1342:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__02838);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__02841);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1349:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1353:1: ( ( 'package' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1354:1: ( 'package' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1354:1: ( 'package' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1355:1: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl2869); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1368:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1372:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1373:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__12900);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__12903);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1380:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1384:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1385:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1385:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1386:1: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1387:1: ( rule__PackageDeclaration__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1387:2: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl2930);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1397:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1401:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1402:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__22960);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__22963);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1409:1: rule__PackageDeclaration__Group__2__Impl : ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1413:1: ( ( ( rule__PackageDeclaration__UsagesAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1414:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1414:1: ( ( rule__PackageDeclaration__UsagesAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1415:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1416:1: ( rule__PackageDeclaration__UsagesAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=29 && LA11_0<=30)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1416:2: rule__PackageDeclaration__UsagesAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl2990);
            	    rule__PackageDeclaration__UsagesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1426:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1430:1: ( rule__PackageDeclaration__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1431:2: rule__PackageDeclaration__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33021);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1437:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1441:1: ( ( ( rule__PackageDeclaration__ModelAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1442:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1442:1: ( ( rule__PackageDeclaration__ModelAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1443:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1444:1: ( rule__PackageDeclaration__ModelAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1444:2: rule__PackageDeclaration__ModelAssignment_3
            {
            pushFollow(FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3048);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1462:1: rule__DOUBLE__Group__0 : rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 ;
    public final void rule__DOUBLE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1466:1: ( rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1467:2: rule__DOUBLE__Group__0__Impl rule__DOUBLE__Group__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03086);
            rule__DOUBLE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03089);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1474:1: rule__DOUBLE__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1478:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1479:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1479:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1480:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3116); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1491:1: rule__DOUBLE__Group__1 : rule__DOUBLE__Group__1__Impl ;
    public final void rule__DOUBLE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1495:1: ( rule__DOUBLE__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1496:2: rule__DOUBLE__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13145);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1502:1: rule__DOUBLE__Group__1__Impl : ( ( rule__DOUBLE__Group_1__0 )? ) ;
    public final void rule__DOUBLE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1506:1: ( ( ( rule__DOUBLE__Group_1__0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1507:1: ( ( rule__DOUBLE__Group_1__0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1507:1: ( ( rule__DOUBLE__Group_1__0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1508:1: ( rule__DOUBLE__Group_1__0 )?
            {
             before(grammarAccess.getDOUBLEAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1509:1: ( rule__DOUBLE__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1509:2: rule__DOUBLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3172);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1523:1: rule__DOUBLE__Group_1__0 : rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 ;
    public final void rule__DOUBLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1527:1: ( rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1528:2: rule__DOUBLE__Group_1__0__Impl rule__DOUBLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03207);
            rule__DOUBLE__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03210);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1535:1: rule__DOUBLE__Group_1__0__Impl : ( '.' ) ;
    public final void rule__DOUBLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1539:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1540:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1540:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1541:1: '.'
            {
             before(grammarAccess.getDOUBLEAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3238); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1554:1: rule__DOUBLE__Group_1__1 : rule__DOUBLE__Group_1__1__Impl ;
    public final void rule__DOUBLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1558:1: ( rule__DOUBLE__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1559:2: rule__DOUBLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13269);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1565:1: rule__DOUBLE__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__DOUBLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1569:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1570:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1570:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1571:1: RULE_INT
            {
             before(grammarAccess.getDOUBLEAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3296); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1586:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1590:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1591:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03329);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03332);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1598:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1602:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1603:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1603:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1604:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3359); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1615:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1619:1: ( rule__QualifiedName__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1620:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13388);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1626:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1630:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1631:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1631:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1632:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1633:1: ( rule__QualifiedName__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==27) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1633:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3415);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1647:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1651:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1652:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03450);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03453);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1659:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1663:1: ( ( '.' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1664:1: ( '.' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1664:1: ( '.' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1665:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3481); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1678:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1682:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1683:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13512);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1689:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1693:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1694:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1694:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1695:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3539); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1710:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1714:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1715:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03572);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03575);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1722:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1726:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1727:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1727:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1728:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl3602);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1739:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1743:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1744:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__13631);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1750:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1754:1: ( ( ( '.*' )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1755:1: ( ( '.*' )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1755:1: ( ( '.*' )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1756:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1757:1: ( '.*' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1758:2: '.*'
                    {
                    match(input,28,FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl3660); 

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1773:1: rule__IQUsage__Group__0 : rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 ;
    public final void rule__IQUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1777:1: ( rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1778:2: rule__IQUsage__Group__0__Impl rule__IQUsage__Group__1
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__03697);
            rule__IQUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__03700);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1785:1: rule__IQUsage__Group__0__Impl : ( 'uses-incquery-patterns' ) ;
    public final void rule__IQUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1789:1: ( ( 'uses-incquery-patterns' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1790:1: ( 'uses-incquery-patterns' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1790:1: ( 'uses-incquery-patterns' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1791:1: 'uses-incquery-patterns'
            {
             before(grammarAccess.getIQUsageAccess().getUsesIncqueryPatternsKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__IQUsage__Group__0__Impl3728); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1804:1: rule__IQUsage__Group__1 : rule__IQUsage__Group__1__Impl ;
    public final void rule__IQUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1808:1: ( rule__IQUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1809:2: rule__IQUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__13759);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1815:1: rule__IQUsage__Group__1__Impl : ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__IQUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1819:1: ( ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1820:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1820:1: ( ( rule__IQUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1821:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1822:1: ( rule__IQUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1822:2: rule__IQUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl3786);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1836:1: rule__EventSourceUsage__Group__0 : rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 ;
    public final void rule__EventSourceUsage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1840:1: ( rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1841:2: rule__EventSourceUsage__Group__0__Impl rule__EventSourceUsage__Group__1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__03820);
            rule__EventSourceUsage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__03823);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1848:1: rule__EventSourceUsage__Group__0__Impl : ( 'uses-eventsources' ) ;
    public final void rule__EventSourceUsage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1852:1: ( ( 'uses-eventsources' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1853:1: ( 'uses-eventsources' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1853:1: ( 'uses-eventsources' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1854:1: 'uses-eventsources'
            {
             before(grammarAccess.getEventSourceUsageAccess().getUsesEventsourcesKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl3851); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1867:1: rule__EventSourceUsage__Group__1 : rule__EventSourceUsage__Group__1__Impl ;
    public final void rule__EventSourceUsage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1871:1: ( rule__EventSourceUsage__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1872:2: rule__EventSourceUsage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__13882);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1878:1: rule__EventSourceUsage__Group__1__Impl : ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__EventSourceUsage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1882:1: ( ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1883:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1883:1: ( ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1884:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1885:1: ( rule__EventSourceUsage__ImportedNamespaceAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1885:2: rule__EventSourceUsage__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl3909);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1899:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1903:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1904:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03943);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03946);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1911:1: rule__Model__Group__0__Impl : ( ( rule__Model__AnnotationsAssignment_0 )* ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1915:1: ( ( ( rule__Model__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1916:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1916:1: ( ( rule__Model__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1917:1: ( rule__Model__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getModelAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1918:1: ( rule__Model__AnnotationsAssignment_0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=46 && LA15_0<=48)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1918:2: rule__Model__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl3973);
            	    rule__Model__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1928:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1932:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1933:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14004);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14007);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1940:1: rule__Model__Group__1__Impl : ( 'EventModel' ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1944:1: ( ( 'EventModel' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( 'EventModel' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1945:1: ( 'EventModel' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1946:1: 'EventModel'
            {
             before(grammarAccess.getModelAccess().getEventModelKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__Model__Group__1__Impl4035); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1959:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1963:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1964:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24066);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24069);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1971:1: rule__Model__Group__2__Impl : ( ( rule__Model__NameAssignment_2 ) ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1975:1: ( ( ( rule__Model__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1976:1: ( ( rule__Model__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1976:1: ( ( rule__Model__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1977:1: ( rule__Model__NameAssignment_2 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1978:1: ( rule__Model__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1978:2: rule__Model__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4096);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1988:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1992:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:1993:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34126);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34129);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2000:1: rule__Model__Group__3__Impl : ( '{' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2004:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2005:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2005:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2006:1: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__Model__Group__3__Impl4157); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2019:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2023:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2024:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44188);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44191);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2031:1: rule__Model__Group__4__Impl : ( ( rule__Model__EventsAssignment_4 )* ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2035:1: ( ( ( rule__Model__EventsAssignment_4 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2036:1: ( ( rule__Model__EventsAssignment_4 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2036:1: ( ( rule__Model__EventsAssignment_4 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2037:1: ( rule__Model__EventsAssignment_4 )*
            {
             before(grammarAccess.getModelAccess().getEventsAssignment_4()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2038:1: ( rule__Model__EventsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==34||LA16_0==40||LA16_0==43||(LA16_0>=46 && LA16_0<=48)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2038:2: rule__Model__EventsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4218);
            	    rule__Model__EventsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2048:1: rule__Model__Group__5 : rule__Model__Group__5__Impl ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2052:1: ( rule__Model__Group__5__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2053:2: rule__Model__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54249);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2059:1: rule__Model__Group__5__Impl : ( '}' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2063:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2064:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2064:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2065:1: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_5()); 
            match(input,33,FOLLOW_33_in_rule__Model__Group__5__Impl4277); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2090:1: rule__AtomicEvent__Group__0 : rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 ;
    public final void rule__AtomicEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2094:1: ( rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2095:2: rule__AtomicEvent__Group__0__Impl rule__AtomicEvent__Group__1
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04320);
            rule__AtomicEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04323);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2102:1: rule__AtomicEvent__Group__0__Impl : ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__AtomicEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2106:1: ( ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2107:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2107:1: ( ( rule__AtomicEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2108:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2109:1: ( rule__AtomicEvent__AnnotationsAssignment_0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=46 && LA17_0<=48)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2109:2: rule__AtomicEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4350);
            	    rule__AtomicEvent__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2119:1: rule__AtomicEvent__Group__1 : rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 ;
    public final void rule__AtomicEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2123:1: ( rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2124:2: rule__AtomicEvent__Group__1__Impl rule__AtomicEvent__Group__2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14381);
            rule__AtomicEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14384);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2131:1: rule__AtomicEvent__Group__1__Impl : ( 'AtomicEvent' ) ;
    public final void rule__AtomicEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2135:1: ( ( 'AtomicEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2136:1: ( 'AtomicEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2136:1: ( 'AtomicEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2137:1: 'AtomicEvent'
            {
             before(grammarAccess.getAtomicEventAccess().getAtomicEventKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4412); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2150:1: rule__AtomicEvent__Group__2 : rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 ;
    public final void rule__AtomicEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2154:1: ( rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2155:2: rule__AtomicEvent__Group__2__Impl rule__AtomicEvent__Group__3
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24443);
            rule__AtomicEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24446);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2162:1: rule__AtomicEvent__Group__2__Impl : ( ( rule__AtomicEvent__NameAssignment_2 ) ) ;
    public final void rule__AtomicEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2166:1: ( ( ( rule__AtomicEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2167:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2167:1: ( ( rule__AtomicEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2168:1: ( rule__AtomicEvent__NameAssignment_2 )
            {
             before(grammarAccess.getAtomicEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2169:1: ( rule__AtomicEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2169:2: rule__AtomicEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4473);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2179:1: rule__AtomicEvent__Group__3 : rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 ;
    public final void rule__AtomicEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2183:1: ( rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2184:2: rule__AtomicEvent__Group__3__Impl rule__AtomicEvent__Group__4
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34503);
            rule__AtomicEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34506);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2191:1: rule__AtomicEvent__Group__3__Impl : ( '()' ) ;
    public final void rule__AtomicEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2195:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2196:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2196:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2197:1: '()'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftParenthesisRightParenthesisKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl4534); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2210:1: rule__AtomicEvent__Group__4 : rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 ;
    public final void rule__AtomicEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2214:1: ( rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2215:2: rule__AtomicEvent__Group__4__Impl rule__AtomicEvent__Group__5
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__44565);
            rule__AtomicEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__44568);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2222:1: rule__AtomicEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2226:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2227:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2227:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2228:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl4596); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2241:1: rule__AtomicEvent__Group__5 : rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 ;
    public final void rule__AtomicEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2245:1: ( rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2246:2: rule__AtomicEvent__Group__5__Impl rule__AtomicEvent__Group__6
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__54627);
            rule__AtomicEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__54630);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2253:1: rule__AtomicEvent__Group__5__Impl : ( 'source' ) ;
    public final void rule__AtomicEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2257:1: ( ( 'source' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2258:1: ( 'source' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2258:1: ( 'source' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2259:1: 'source'
            {
             before(grammarAccess.getAtomicEventAccess().getSourceKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl4658); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2272:1: rule__AtomicEvent__Group__6 : rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 ;
    public final void rule__AtomicEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2276:1: ( rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2277:2: rule__AtomicEvent__Group__6__Impl rule__AtomicEvent__Group__7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__64689);
            rule__AtomicEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__64692);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2284:1: rule__AtomicEvent__Group__6__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2288:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2289:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2289:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2290:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_6()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl4720); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2303:1: rule__AtomicEvent__Group__7 : rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 ;
    public final void rule__AtomicEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2307:1: ( rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2308:2: rule__AtomicEvent__Group__7__Impl rule__AtomicEvent__Group__8
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__74751);
            rule__AtomicEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__74754);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2315:1: rule__AtomicEvent__Group__7__Impl : ( ( rule__AtomicEvent__SourceAssignment_7 ) ) ;
    public final void rule__AtomicEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2319:1: ( ( ( rule__AtomicEvent__SourceAssignment_7 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2320:1: ( ( rule__AtomicEvent__SourceAssignment_7 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2320:1: ( ( rule__AtomicEvent__SourceAssignment_7 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2321:1: ( rule__AtomicEvent__SourceAssignment_7 )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceAssignment_7()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2322:1: ( rule__AtomicEvent__SourceAssignment_7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2322:2: rule__AtomicEvent__SourceAssignment_7
            {
            pushFollow(FOLLOW_rule__AtomicEvent__SourceAssignment_7_in_rule__AtomicEvent__Group__7__Impl4781);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2332:1: rule__AtomicEvent__Group__8 : rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 ;
    public final void rule__AtomicEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2336:1: ( rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2337:2: rule__AtomicEvent__Group__8__Impl rule__AtomicEvent__Group__9
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__84811);
            rule__AtomicEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__84814);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2344:1: rule__AtomicEvent__Group__8__Impl : ( 'id' ) ;
    public final void rule__AtomicEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2348:1: ( ( 'id' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2349:1: ( 'id' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2349:1: ( 'id' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2350:1: 'id'
            {
             before(grammarAccess.getAtomicEventAccess().getIdKeyword_8()); 
            match(input,38,FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl4842); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2363:1: rule__AtomicEvent__Group__9 : rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 ;
    public final void rule__AtomicEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2367:1: ( rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2368:2: rule__AtomicEvent__Group__9__Impl rule__AtomicEvent__Group__10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__94873);
            rule__AtomicEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__94876);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2375:1: rule__AtomicEvent__Group__9__Impl : ( ':' ) ;
    public final void rule__AtomicEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2379:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2380:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2380:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2381:1: ':'
            {
             before(grammarAccess.getAtomicEventAccess().getColonKeyword_9()); 
            match(input,37,FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl4904); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2394:1: rule__AtomicEvent__Group__10 : rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 ;
    public final void rule__AtomicEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2398:1: ( rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2399:2: rule__AtomicEvent__Group__10__Impl rule__AtomicEvent__Group__11
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__104935);
            rule__AtomicEvent__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__104938);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2406:1: rule__AtomicEvent__Group__10__Impl : ( ( rule__AtomicEvent__IdAssignment_10 ) ) ;
    public final void rule__AtomicEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2410:1: ( ( ( rule__AtomicEvent__IdAssignment_10 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2411:1: ( ( rule__AtomicEvent__IdAssignment_10 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2411:1: ( ( rule__AtomicEvent__IdAssignment_10 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2412:1: ( rule__AtomicEvent__IdAssignment_10 )
            {
             before(grammarAccess.getAtomicEventAccess().getIdAssignment_10()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2413:1: ( rule__AtomicEvent__IdAssignment_10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2413:2: rule__AtomicEvent__IdAssignment_10
            {
            pushFollow(FOLLOW_rule__AtomicEvent__IdAssignment_10_in_rule__AtomicEvent__Group__10__Impl4965);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2423:1: rule__AtomicEvent__Group__11 : rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 ;
    public final void rule__AtomicEvent__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2427:1: ( rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2428:2: rule__AtomicEvent__Group__11__Impl rule__AtomicEvent__Group__12
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__114995);
            rule__AtomicEvent__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__114998);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2435:1: rule__AtomicEvent__Group__11__Impl : ( 'parameterFilters' ) ;
    public final void rule__AtomicEvent__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2439:1: ( ( 'parameterFilters' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2440:1: ( 'parameterFilters' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2440:1: ( 'parameterFilters' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2441:1: 'parameterFilters'
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersKeyword_11()); 
            match(input,39,FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5026); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2454:1: rule__AtomicEvent__Group__12 : rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 ;
    public final void rule__AtomicEvent__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2458:1: ( rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2459:2: rule__AtomicEvent__Group__12__Impl rule__AtomicEvent__Group__13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125057);
            rule__AtomicEvent__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125060);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2466:1: rule__AtomicEvent__Group__12__Impl : ( '{' ) ;
    public final void rule__AtomicEvent__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2470:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2471:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2471:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2472:1: '{'
            {
             before(grammarAccess.getAtomicEventAccess().getLeftCurlyBracketKeyword_12()); 
            match(input,32,FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5088); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2485:1: rule__AtomicEvent__Group__13 : rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 ;
    public final void rule__AtomicEvent__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2489:1: ( rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2490:2: rule__AtomicEvent__Group__13__Impl rule__AtomicEvent__Group__14
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135119);
            rule__AtomicEvent__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135122);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2497:1: rule__AtomicEvent__Group__13__Impl : ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) ;
    public final void rule__AtomicEvent__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2501:1: ( ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2502:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2502:1: ( ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2503:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) ) ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2503:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2504:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2505:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2505:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            {
            pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5151);
            rule__AtomicEvent__ParameterFiltersAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 

            }

            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2508:1: ( ( rule__AtomicEvent__ParameterFiltersAssignment_13 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2509:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersAssignment_13()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2510:1: ( rule__AtomicEvent__ParameterFiltersAssignment_13 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2510:2: rule__AtomicEvent__ParameterFiltersAssignment_13
            	    {
            	    pushFollow(FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5163);
            	    rule__AtomicEvent__ParameterFiltersAssignment_13();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2521:1: rule__AtomicEvent__Group__14 : rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 ;
    public final void rule__AtomicEvent__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2525:1: ( rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2526:2: rule__AtomicEvent__Group__14__Impl rule__AtomicEvent__Group__15
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145196);
            rule__AtomicEvent__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145199);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2533:1: rule__AtomicEvent__Group__14__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2537:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2538:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2538:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2539:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_14()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5227); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2552:1: rule__AtomicEvent__Group__15 : rule__AtomicEvent__Group__15__Impl ;
    public final void rule__AtomicEvent__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2556:1: ( rule__AtomicEvent__Group__15__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2557:2: rule__AtomicEvent__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155258);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2563:1: rule__AtomicEvent__Group__15__Impl : ( '}' ) ;
    public final void rule__AtomicEvent__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2567:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2568:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2568:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2569:1: '}'
            {
             before(grammarAccess.getAtomicEventAccess().getRightCurlyBracketKeyword_15()); 
            match(input,33,FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5286); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2614:1: rule__IQPatternEvent__Group__0 : rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 ;
    public final void rule__IQPatternEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2618:1: ( rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2619:2: rule__IQPatternEvent__Group__0__Impl rule__IQPatternEvent__Group__1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05349);
            rule__IQPatternEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05352);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2626:1: rule__IQPatternEvent__Group__0__Impl : ( 'IQPatternEvent' ) ;
    public final void rule__IQPatternEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2630:1: ( ( 'IQPatternEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2631:1: ( 'IQPatternEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2631:1: ( 'IQPatternEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2632:1: 'IQPatternEvent'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternEventKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5380); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2645:1: rule__IQPatternEvent__Group__1 : rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 ;
    public final void rule__IQPatternEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2649:1: ( rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2650:2: rule__IQPatternEvent__Group__1__Impl rule__IQPatternEvent__Group__2
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15411);
            rule__IQPatternEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15414);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2657:1: rule__IQPatternEvent__Group__1__Impl : ( ( rule__IQPatternEvent__NameAssignment_1 ) ) ;
    public final void rule__IQPatternEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2661:1: ( ( ( rule__IQPatternEvent__NameAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2662:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2662:1: ( ( rule__IQPatternEvent__NameAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2663:1: ( rule__IQPatternEvent__NameAssignment_1 )
            {
             before(grammarAccess.getIQPatternEventAccess().getNameAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2664:1: ( rule__IQPatternEvent__NameAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2664:2: rule__IQPatternEvent__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5441);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2674:1: rule__IQPatternEvent__Group__2 : rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 ;
    public final void rule__IQPatternEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2678:1: ( rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2679:2: rule__IQPatternEvent__Group__2__Impl rule__IQPatternEvent__Group__3
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25471);
            rule__IQPatternEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25474);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2686:1: rule__IQPatternEvent__Group__2__Impl : ( '()' ) ;
    public final void rule__IQPatternEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2690:1: ( ( '()' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2691:1: ( '()' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2691:1: ( '()' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2692:1: '()'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftParenthesisRightParenthesisKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5502); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2705:1: rule__IQPatternEvent__Group__3 : rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 ;
    public final void rule__IQPatternEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2709:1: ( rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2710:2: rule__IQPatternEvent__Group__3__Impl rule__IQPatternEvent__Group__4
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__35533);
            rule__IQPatternEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__35536);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2717:1: rule__IQPatternEvent__Group__3__Impl : ( '{' ) ;
    public final void rule__IQPatternEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2721:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2722:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2722:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2723:1: '{'
            {
             before(grammarAccess.getIQPatternEventAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,32,FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl5564); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2736:1: rule__IQPatternEvent__Group__4 : rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 ;
    public final void rule__IQPatternEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2740:1: ( rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2741:2: rule__IQPatternEvent__Group__4__Impl rule__IQPatternEvent__Group__5
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__45595);
            rule__IQPatternEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__45598);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2748:1: rule__IQPatternEvent__Group__4__Impl : ( 'IQPatternRef' ) ;
    public final void rule__IQPatternEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2752:1: ( ( 'IQPatternRef' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2753:1: ( 'IQPatternRef' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2753:1: ( 'IQPatternRef' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2754:1: 'IQPatternRef'
            {
             before(grammarAccess.getIQPatternEventAccess().getIQPatternRefKeyword_4()); 
            match(input,41,FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl5626); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2767:1: rule__IQPatternEvent__Group__5 : rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 ;
    public final void rule__IQPatternEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2771:1: ( rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2772:2: rule__IQPatternEvent__Group__5__Impl rule__IQPatternEvent__Group__6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__55657);
            rule__IQPatternEvent__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__55660);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2779:1: rule__IQPatternEvent__Group__5__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2783:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2784:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2784:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2785:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_5()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl5688); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2798:1: rule__IQPatternEvent__Group__6 : rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 ;
    public final void rule__IQPatternEvent__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2802:1: ( rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2803:2: rule__IQPatternEvent__Group__6__Impl rule__IQPatternEvent__Group__7
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__65719);
            rule__IQPatternEvent__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__65722);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2810:1: rule__IQPatternEvent__Group__6__Impl : ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) ;
    public final void rule__IQPatternEvent__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2814:1: ( ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2815:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2815:1: ( ( rule__IQPatternEvent__IqpatternAssignment_6 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2816:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternAssignment_6()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2817:1: ( rule__IQPatternEvent__IqpatternAssignment_6 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2817:2: rule__IQPatternEvent__IqpatternAssignment_6
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl5749);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2827:1: rule__IQPatternEvent__Group__7 : rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 ;
    public final void rule__IQPatternEvent__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2831:1: ( rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2832:2: rule__IQPatternEvent__Group__7__Impl rule__IQPatternEvent__Group__8
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__75779);
            rule__IQPatternEvent__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__75782);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2839:1: rule__IQPatternEvent__Group__7__Impl : ( 'ChangeType' ) ;
    public final void rule__IQPatternEvent__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2843:1: ( ( 'ChangeType' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2844:1: ( 'ChangeType' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2844:1: ( 'ChangeType' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2845:1: 'ChangeType'
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeKeyword_7()); 
            match(input,42,FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl5810); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2858:1: rule__IQPatternEvent__Group__8 : rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 ;
    public final void rule__IQPatternEvent__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2862:1: ( rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2863:2: rule__IQPatternEvent__Group__8__Impl rule__IQPatternEvent__Group__9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__85841);
            rule__IQPatternEvent__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__85844);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2870:1: rule__IQPatternEvent__Group__8__Impl : ( ':' ) ;
    public final void rule__IQPatternEvent__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2874:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2875:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2875:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2876:1: ':'
            {
             before(grammarAccess.getIQPatternEventAccess().getColonKeyword_8()); 
            match(input,37,FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl5872); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2889:1: rule__IQPatternEvent__Group__9 : rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 ;
    public final void rule__IQPatternEvent__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2893:1: ( rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2894:2: rule__IQPatternEvent__Group__9__Impl rule__IQPatternEvent__Group__10
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__95903);
            rule__IQPatternEvent__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__95906);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2901:1: rule__IQPatternEvent__Group__9__Impl : ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) ;
    public final void rule__IQPatternEvent__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2905:1: ( ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2906:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2906:1: ( ( rule__IQPatternEvent__ChangeTypeAssignment_9 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2907:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeAssignment_9()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2908:1: ( rule__IQPatternEvent__ChangeTypeAssignment_9 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2908:2: rule__IQPatternEvent__ChangeTypeAssignment_9
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl5933);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2918:1: rule__IQPatternEvent__Group__10 : rule__IQPatternEvent__Group__10__Impl ;
    public final void rule__IQPatternEvent__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2922:1: ( rule__IQPatternEvent__Group__10__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2923:2: rule__IQPatternEvent__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__105963);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2929:1: rule__IQPatternEvent__Group__10__Impl : ( '}' ) ;
    public final void rule__IQPatternEvent__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2933:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2934:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2934:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2935:1: '}'
            {
             before(grammarAccess.getIQPatternEventAccess().getRightCurlyBracketKeyword_10()); 
            match(input,33,FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl5991); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2970:1: rule__ComplexEvent__Group__0 : rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 ;
    public final void rule__ComplexEvent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2974:1: ( rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2975:2: rule__ComplexEvent__Group__0__Impl rule__ComplexEvent__Group__1
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06044);
            rule__ComplexEvent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06047);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2982:1: rule__ComplexEvent__Group__0__Impl : ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) ;
    public final void rule__ComplexEvent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2986:1: ( ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2987:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2987:1: ( ( rule__ComplexEvent__AnnotationsAssignment_0 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2988:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2989:1: ( rule__ComplexEvent__AnnotationsAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=46 && LA19_0<=48)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2989:2: rule__ComplexEvent__AnnotationsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6074);
            	    rule__ComplexEvent__AnnotationsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:2999:1: rule__ComplexEvent__Group__1 : rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 ;
    public final void rule__ComplexEvent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3003:1: ( rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3004:2: rule__ComplexEvent__Group__1__Impl rule__ComplexEvent__Group__2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16105);
            rule__ComplexEvent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16108);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3011:1: rule__ComplexEvent__Group__1__Impl : ( 'ComplexEvent' ) ;
    public final void rule__ComplexEvent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3015:1: ( ( 'ComplexEvent' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3016:1: ( 'ComplexEvent' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3016:1: ( 'ComplexEvent' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3017:1: 'ComplexEvent'
            {
             before(grammarAccess.getComplexEventAccess().getComplexEventKeyword_1()); 
            match(input,43,FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6136); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3030:1: rule__ComplexEvent__Group__2 : rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 ;
    public final void rule__ComplexEvent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3034:1: ( rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3035:2: rule__ComplexEvent__Group__2__Impl rule__ComplexEvent__Group__3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26167);
            rule__ComplexEvent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26170);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3042:1: rule__ComplexEvent__Group__2__Impl : ( ( rule__ComplexEvent__NameAssignment_2 ) ) ;
    public final void rule__ComplexEvent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3046:1: ( ( ( rule__ComplexEvent__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3047:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3047:1: ( ( rule__ComplexEvent__NameAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3048:1: ( rule__ComplexEvent__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEventAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3049:1: ( rule__ComplexEvent__NameAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3049:2: rule__ComplexEvent__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6197);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3059:1: rule__ComplexEvent__Group__3 : rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 ;
    public final void rule__ComplexEvent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3063:1: ( rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3064:2: rule__ComplexEvent__Group__3__Impl rule__ComplexEvent__Group__4
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36227);
            rule__ComplexEvent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36230);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3071:1: rule__ComplexEvent__Group__3__Impl : ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) ;
    public final void rule__ComplexEvent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3075:1: ( ( ( rule__ComplexEvent__ParamlistAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3076:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3076:1: ( ( rule__ComplexEvent__ParamlistAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3077:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            {
             before(grammarAccess.getComplexEventAccess().getParamlistAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3078:1: ( rule__ComplexEvent__ParamlistAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3078:2: rule__ComplexEvent__ParamlistAssignment_3
            {
            pushFollow(FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6257);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3088:1: rule__ComplexEvent__Group__4 : rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 ;
    public final void rule__ComplexEvent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3092:1: ( rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3093:2: rule__ComplexEvent__Group__4__Impl rule__ComplexEvent__Group__5
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46287);
            rule__ComplexEvent__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46290);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3100:1: rule__ComplexEvent__Group__4__Impl : ( '{' ) ;
    public final void rule__ComplexEvent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3104:1: ( ( '{' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3105:1: ( '{' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3105:1: ( '{' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3106:1: '{'
            {
             before(grammarAccess.getComplexEventAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,32,FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6318); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3119:1: rule__ComplexEvent__Group__5 : rule__ComplexEvent__Group__5__Impl ;
    public final void rule__ComplexEvent__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3123:1: ( rule__ComplexEvent__Group__5__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3124:2: rule__ComplexEvent__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56349);
            rule__ComplexEvent__Group__5__Impl();

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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3130:1: rule__ComplexEvent__Group__5__Impl : ( '}' ) ;
    public final void rule__ComplexEvent__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3134:1: ( ( '}' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3135:1: ( '}' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3135:1: ( '}' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3136:1: '}'
            {
             before(grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_5()); 
            match(input,33,FOLLOW_33_in_rule__ComplexEvent__Group__5__Impl6377); 
             after(grammarAccess.getComplexEventAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__CEParamlist__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3161:1: rule__CEParamlist__Group__0 : rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 ;
    public final void rule__CEParamlist__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3165:1: ( rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3166:2: rule__CEParamlist__Group__0__Impl rule__CEParamlist__Group__1
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06420);
            rule__CEParamlist__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06423);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3173:1: rule__CEParamlist__Group__0__Impl : ( () ) ;
    public final void rule__CEParamlist__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3177:1: ( ( () ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3178:1: ( () )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3178:1: ( () )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3179:1: ()
            {
             before(grammarAccess.getCEParamlistAccess().getCEParamlistAction_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3180:1: ()
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3182:1: 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3192:1: rule__CEParamlist__Group__1 : rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 ;
    public final void rule__CEParamlist__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3196:1: ( rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3197:2: rule__CEParamlist__Group__1__Impl rule__CEParamlist__Group__2
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__16481);
            rule__CEParamlist__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__16484);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3204:1: rule__CEParamlist__Group__1__Impl : ( '(' ) ;
    public final void rule__CEParamlist__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3208:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3209:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3209:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3210:1: '('
            {
             before(grammarAccess.getCEParamlistAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__CEParamlist__Group__1__Impl6512); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3223:1: rule__CEParamlist__Group__2 : rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 ;
    public final void rule__CEParamlist__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3227:1: ( rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3228:2: rule__CEParamlist__Group__2__Impl rule__CEParamlist__Group__3
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__26543);
            rule__CEParamlist__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__26546);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3235:1: rule__CEParamlist__Group__2__Impl : ( ( rule__CEParamlist__ParamsAssignment_2 )* ) ;
    public final void rule__CEParamlist__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3239:1: ( ( ( rule__CEParamlist__ParamsAssignment_2 )* ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3240:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3240:1: ( ( rule__CEParamlist__ParamsAssignment_2 )* )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3241:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            {
             before(grammarAccess.getCEParamlistAccess().getParamsAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3242:1: ( rule__CEParamlist__ParamsAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3242:2: rule__CEParamlist__ParamsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl6573);
            	    rule__CEParamlist__ParamsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3252:1: rule__CEParamlist__Group__3 : rule__CEParamlist__Group__3__Impl ;
    public final void rule__CEParamlist__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3256:1: ( rule__CEParamlist__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3257:2: rule__CEParamlist__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__36604);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3263:1: rule__CEParamlist__Group__3__Impl : ( ')' ) ;
    public final void rule__CEParamlist__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3267:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3268:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3268:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3269:1: ')'
            {
             before(grammarAccess.getCEParamlistAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__CEParamlist__Group__3__Impl6632); 
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


    // $ANTLR start "rule__ParamWithType__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3290:1: rule__ParamWithType__Group__0 : rule__ParamWithType__Group__0__Impl rule__ParamWithType__Group__1 ;
    public final void rule__ParamWithType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3294:1: ( rule__ParamWithType__Group__0__Impl rule__ParamWithType__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3295:2: rule__ParamWithType__Group__0__Impl rule__ParamWithType__Group__1
            {
            pushFollow(FOLLOW_rule__ParamWithType__Group__0__Impl_in_rule__ParamWithType__Group__06671);
            rule__ParamWithType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParamWithType__Group__1_in_rule__ParamWithType__Group__06674);
            rule__ParamWithType__Group__1();

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
    // $ANTLR end "rule__ParamWithType__Group__0"


    // $ANTLR start "rule__ParamWithType__Group__0__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3302:1: rule__ParamWithType__Group__0__Impl : ( ( rule__ParamWithType__NameAssignment_0 ) ) ;
    public final void rule__ParamWithType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3306:1: ( ( ( rule__ParamWithType__NameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3307:1: ( ( rule__ParamWithType__NameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3307:1: ( ( rule__ParamWithType__NameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3308:1: ( rule__ParamWithType__NameAssignment_0 )
            {
             before(grammarAccess.getParamWithTypeAccess().getNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3309:1: ( rule__ParamWithType__NameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3309:2: rule__ParamWithType__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ParamWithType__NameAssignment_0_in_rule__ParamWithType__Group__0__Impl6701);
            rule__ParamWithType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParamWithTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamWithType__Group__0__Impl"


    // $ANTLR start "rule__ParamWithType__Group__1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3319:1: rule__ParamWithType__Group__1 : rule__ParamWithType__Group__1__Impl rule__ParamWithType__Group__2 ;
    public final void rule__ParamWithType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3323:1: ( rule__ParamWithType__Group__1__Impl rule__ParamWithType__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3324:2: rule__ParamWithType__Group__1__Impl rule__ParamWithType__Group__2
            {
            pushFollow(FOLLOW_rule__ParamWithType__Group__1__Impl_in_rule__ParamWithType__Group__16731);
            rule__ParamWithType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParamWithType__Group__2_in_rule__ParamWithType__Group__16734);
            rule__ParamWithType__Group__2();

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
    // $ANTLR end "rule__ParamWithType__Group__1"


    // $ANTLR start "rule__ParamWithType__Group__1__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3331:1: rule__ParamWithType__Group__1__Impl : ( ':' ) ;
    public final void rule__ParamWithType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3335:1: ( ( ':' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3336:1: ( ':' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3336:1: ( ':' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3337:1: ':'
            {
             before(grammarAccess.getParamWithTypeAccess().getColonKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__ParamWithType__Group__1__Impl6762); 
             after(grammarAccess.getParamWithTypeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamWithType__Group__1__Impl"


    // $ANTLR start "rule__ParamWithType__Group__2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3350:1: rule__ParamWithType__Group__2 : rule__ParamWithType__Group__2__Impl ;
    public final void rule__ParamWithType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3354:1: ( rule__ParamWithType__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3355:2: rule__ParamWithType__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParamWithType__Group__2__Impl_in_rule__ParamWithType__Group__26793);
            rule__ParamWithType__Group__2__Impl();

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
    // $ANTLR end "rule__ParamWithType__Group__2"


    // $ANTLR start "rule__ParamWithType__Group__2__Impl"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3361:1: rule__ParamWithType__Group__2__Impl : ( ( rule__ParamWithType__TypeAssignment_2 ) ) ;
    public final void rule__ParamWithType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3365:1: ( ( ( rule__ParamWithType__TypeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3366:1: ( ( rule__ParamWithType__TypeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3366:1: ( ( rule__ParamWithType__TypeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3367:1: ( rule__ParamWithType__TypeAssignment_2 )
            {
             before(grammarAccess.getParamWithTypeAccess().getTypeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3368:1: ( rule__ParamWithType__TypeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3368:2: rule__ParamWithType__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__ParamWithType__TypeAssignment_2_in_rule__ParamWithType__Group__2__Impl6820);
            rule__ParamWithType__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParamWithTypeAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamWithType__Group__2__Impl"


    // $ANTLR start "rule__ParameterFilter__Group__0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3384:1: rule__ParameterFilter__Group__0 : rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 ;
    public final void rule__ParameterFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3388:1: ( rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3389:2: rule__ParameterFilter__Group__0__Impl rule__ParameterFilter__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__06856);
            rule__ParameterFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__06859);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3396:1: rule__ParameterFilter__Group__0__Impl : ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) ;
    public final void rule__ParameterFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3400:1: ( ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3401:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3401:1: ( ( rule__ParameterFilter__AttributeNameAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3402:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3403:1: ( rule__ParameterFilter__AttributeNameAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3403:2: rule__ParameterFilter__AttributeNameAssignment_0
            {
            pushFollow(FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl6886);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3413:1: rule__ParameterFilter__Group__1 : rule__ParameterFilter__Group__1__Impl ;
    public final void rule__ParameterFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3417:1: ( rule__ParameterFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3418:2: rule__ParameterFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__16916);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3424:1: rule__ParameterFilter__Group__1__Impl : ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) ;
    public final void rule__ParameterFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3428:1: ( ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3429:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3429:1: ( ( rule__ParameterFilter__ParamFilterRuleAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3430:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3431:1: ( rule__ParameterFilter__ParamFilterRuleAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3431:2: rule__ParameterFilter__ParamFilterRuleAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl6943);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3445:1: rule__ContextAnnotation__Group__0 : rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 ;
    public final void rule__ContextAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3449:1: ( rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3450:2: rule__ContextAnnotation__Group__0__Impl rule__ContextAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__06977);
            rule__ContextAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__06980);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3457:1: rule__ContextAnnotation__Group__0__Impl : ( '@Context' ) ;
    public final void rule__ContextAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3461:1: ( ( '@Context' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3462:1: ( '@Context' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3462:1: ( '@Context' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3463:1: '@Context'
            {
             before(grammarAccess.getContextAnnotationAccess().getContextKeyword_0()); 
            match(input,46,FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7008); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3476:1: rule__ContextAnnotation__Group__1 : rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 ;
    public final void rule__ContextAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3480:1: ( rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3481:2: rule__ContextAnnotation__Group__1__Impl rule__ContextAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17039);
            rule__ContextAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17042);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3488:1: rule__ContextAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__ContextAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3492:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3493:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3493:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3494:1: '('
            {
             before(grammarAccess.getContextAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7070); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3507:1: rule__ContextAnnotation__Group__2 : rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 ;
    public final void rule__ContextAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3511:1: ( rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3512:2: rule__ContextAnnotation__Group__2__Impl rule__ContextAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27101);
            rule__ContextAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27104);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3519:1: rule__ContextAnnotation__Group__2__Impl : ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) ;
    public final void rule__ContextAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3523:1: ( ( ( rule__ContextAnnotation__ContextAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3524:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3524:1: ( ( rule__ContextAnnotation__ContextAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3525:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            {
             before(grammarAccess.getContextAnnotationAccess().getContextAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3526:1: ( rule__ContextAnnotation__ContextAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3526:2: rule__ContextAnnotation__ContextAssignment_2
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7131);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3536:1: rule__ContextAnnotation__Group__3 : rule__ContextAnnotation__Group__3__Impl ;
    public final void rule__ContextAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3540:1: ( rule__ContextAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3541:2: rule__ContextAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37161);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3547:1: rule__ContextAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__ContextAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3551:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3552:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3552:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3553:1: ')'
            {
             before(grammarAccess.getContextAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7189); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3574:1: rule__SamplingAnnotation__Group__0 : rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 ;
    public final void rule__SamplingAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3578:1: ( rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3579:2: rule__SamplingAnnotation__Group__0__Impl rule__SamplingAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07228);
            rule__SamplingAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07231);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3586:1: rule__SamplingAnnotation__Group__0__Impl : ( '@SamplingTime' ) ;
    public final void rule__SamplingAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3590:1: ( ( '@SamplingTime' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3591:1: ( '@SamplingTime' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3591:1: ( '@SamplingTime' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3592:1: '@SamplingTime'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingTimeKeyword_0()); 
            match(input,47,FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7259); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3605:1: rule__SamplingAnnotation__Group__1 : rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 ;
    public final void rule__SamplingAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3609:1: ( rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3610:2: rule__SamplingAnnotation__Group__1__Impl rule__SamplingAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17290);
            rule__SamplingAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17293);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3617:1: rule__SamplingAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__SamplingAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3621:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3622:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3622:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3623:1: '('
            {
             before(grammarAccess.getSamplingAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7321); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3636:1: rule__SamplingAnnotation__Group__2 : rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 ;
    public final void rule__SamplingAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3640:1: ( rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3641:2: rule__SamplingAnnotation__Group__2__Impl rule__SamplingAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27352);
            rule__SamplingAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27355);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3648:1: rule__SamplingAnnotation__Group__2__Impl : ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) ;
    public final void rule__SamplingAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3652:1: ( ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3653:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3653:1: ( ( rule__SamplingAnnotation__SamplingAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3654:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3655:1: ( rule__SamplingAnnotation__SamplingAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3655:2: rule__SamplingAnnotation__SamplingAssignment_2
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7382);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3665:1: rule__SamplingAnnotation__Group__3 : rule__SamplingAnnotation__Group__3__Impl ;
    public final void rule__SamplingAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3669:1: ( rule__SamplingAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3670:2: rule__SamplingAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37412);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3676:1: rule__SamplingAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__SamplingAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3680:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3681:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3681:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3682:1: ')'
            {
             before(grammarAccess.getSamplingAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7440); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3703:1: rule__PriorityAnnotation__Group__0 : rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 ;
    public final void rule__PriorityAnnotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3707:1: ( rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3708:2: rule__PriorityAnnotation__Group__0__Impl rule__PriorityAnnotation__Group__1
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__07479);
            rule__PriorityAnnotation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__07482);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3715:1: rule__PriorityAnnotation__Group__0__Impl : ( '@Priority' ) ;
    public final void rule__PriorityAnnotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3719:1: ( ( '@Priority' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3720:1: ( '@Priority' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3720:1: ( '@Priority' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3721:1: '@Priority'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityKeyword_0()); 
            match(input,48,FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl7510); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3734:1: rule__PriorityAnnotation__Group__1 : rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 ;
    public final void rule__PriorityAnnotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3738:1: ( rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3739:2: rule__PriorityAnnotation__Group__1__Impl rule__PriorityAnnotation__Group__2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__17541);
            rule__PriorityAnnotation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__17544);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3746:1: rule__PriorityAnnotation__Group__1__Impl : ( '(' ) ;
    public final void rule__PriorityAnnotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3750:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3751:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3751:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3752:1: '('
            {
             before(grammarAccess.getPriorityAnnotationAccess().getLeftParenthesisKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl7572); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3765:1: rule__PriorityAnnotation__Group__2 : rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 ;
    public final void rule__PriorityAnnotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3769:1: ( rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3770:2: rule__PriorityAnnotation__Group__2__Impl rule__PriorityAnnotation__Group__3
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__27603);
            rule__PriorityAnnotation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__27606);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3777:1: rule__PriorityAnnotation__Group__2__Impl : ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) ;
    public final void rule__PriorityAnnotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3781:1: ( ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3782:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3782:1: ( ( rule__PriorityAnnotation__PriorityAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3783:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3784:1: ( rule__PriorityAnnotation__PriorityAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3784:2: rule__PriorityAnnotation__PriorityAssignment_2
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl7633);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3794:1: rule__PriorityAnnotation__Group__3 : rule__PriorityAnnotation__Group__3__Impl ;
    public final void rule__PriorityAnnotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3798:1: ( rule__PriorityAnnotation__Group__3__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3799:2: rule__PriorityAnnotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__37663);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3805:1: rule__PriorityAnnotation__Group__3__Impl : ( ')' ) ;
    public final void rule__PriorityAnnotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3809:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3810:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3810:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3811:1: ')'
            {
             before(grammarAccess.getPriorityAnnotationAccess().getRightParenthesisKeyword_3()); 
            match(input,45,FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl7691); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3832:1: rule__RangeFilter__Group__0 : rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 ;
    public final void rule__RangeFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3836:1: ( rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3837:2: rule__RangeFilter__Group__0__Impl rule__RangeFilter__Group__1
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__07730);
            rule__RangeFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__07733);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3844:1: rule__RangeFilter__Group__0__Impl : ( ( rule__RangeFilter__NegAssignment_0 )? ) ;
    public final void rule__RangeFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3848:1: ( ( ( rule__RangeFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3849:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3849:1: ( ( rule__RangeFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3850:1: ( rule__RangeFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getRangeFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3851:1: ( rule__RangeFilter__NegAssignment_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==11) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3851:2: rule__RangeFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl7760);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3861:1: rule__RangeFilter__Group__1 : rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 ;
    public final void rule__RangeFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3865:1: ( rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3866:2: rule__RangeFilter__Group__1__Impl rule__RangeFilter__Group__2
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__17791);
            rule__RangeFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__17794);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3873:1: rule__RangeFilter__Group__1__Impl : ( 'in' ) ;
    public final void rule__RangeFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3877:1: ( ( 'in' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3878:1: ( 'in' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3878:1: ( 'in' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3879:1: 'in'
            {
             before(grammarAccess.getRangeFilterAccess().getInKeyword_1()); 
            match(input,49,FOLLOW_49_in_rule__RangeFilter__Group__1__Impl7822); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3892:1: rule__RangeFilter__Group__2 : rule__RangeFilter__Group__2__Impl ;
    public final void rule__RangeFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3896:1: ( rule__RangeFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3897:2: rule__RangeFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__27853);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3903:1: rule__RangeFilter__Group__2__Impl : ( ( rule__RangeFilter__RangeAssignment_2 ) ) ;
    public final void rule__RangeFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3907:1: ( ( ( rule__RangeFilter__RangeAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3908:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3908:1: ( ( rule__RangeFilter__RangeAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3909:1: ( rule__RangeFilter__RangeAssignment_2 )
            {
             before(grammarAccess.getRangeFilterAccess().getRangeAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3910:1: ( rule__RangeFilter__RangeAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3910:2: rule__RangeFilter__RangeAssignment_2
            {
            pushFollow(FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl7880);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3926:1: rule__OpenOpen__Group__0 : rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 ;
    public final void rule__OpenOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3930:1: ( rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3931:2: rule__OpenOpen__Group__0__Impl rule__OpenOpen__Group__1
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__07916);
            rule__OpenOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__07919);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3938:1: rule__OpenOpen__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3942:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3943:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3943:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3944:1: '('
            {
             before(grammarAccess.getOpenOpenAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenOpen__Group__0__Impl7947); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3957:1: rule__OpenOpen__Group__1 : rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 ;
    public final void rule__OpenOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3961:1: ( rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3962:2: rule__OpenOpen__Group__1__Impl rule__OpenOpen__Group__2
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__17978);
            rule__OpenOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__17981);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3969:1: rule__OpenOpen__Group__1__Impl : ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3973:1: ( ( ( rule__OpenOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3974:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3974:1: ( ( rule__OpenOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3975:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3976:1: ( rule__OpenOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3976:2: rule__OpenOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8008);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3986:1: rule__OpenOpen__Group__2 : rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 ;
    public final void rule__OpenOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3990:1: ( rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3991:2: rule__OpenOpen__Group__2__Impl rule__OpenOpen__Group__3
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28038);
            rule__OpenOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28041);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:3998:1: rule__OpenOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4002:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4003:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4003:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4004:1: ','
            {
             before(grammarAccess.getOpenOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8069); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4017:1: rule__OpenOpen__Group__3 : rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 ;
    public final void rule__OpenOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4021:1: ( rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4022:2: rule__OpenOpen__Group__3__Impl rule__OpenOpen__Group__4
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38100);
            rule__OpenOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38103);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4029:1: rule__OpenOpen__Group__3__Impl : ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4033:1: ( ( ( rule__OpenOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4034:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4034:1: ( ( rule__OpenOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4035:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4036:1: ( rule__OpenOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4036:2: rule__OpenOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8130);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4046:1: rule__OpenOpen__Group__4 : rule__OpenOpen__Group__4__Impl ;
    public final void rule__OpenOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4050:1: ( rule__OpenOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4051:2: rule__OpenOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48160);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4057:1: rule__OpenOpen__Group__4__Impl : ( ')' ) ;
    public final void rule__OpenOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4061:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4062:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4062:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4063:1: ')'
            {
             before(grammarAccess.getOpenOpenAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8188); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4086:1: rule__OpenClosed__Group__0 : rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 ;
    public final void rule__OpenClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4090:1: ( rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4091:2: rule__OpenClosed__Group__0__Impl rule__OpenClosed__Group__1
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08229);
            rule__OpenClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08232);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4098:1: rule__OpenClosed__Group__0__Impl : ( '(' ) ;
    public final void rule__OpenClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4102:1: ( ( '(' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4103:1: ( '(' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4103:1: ( '(' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4104:1: '('
            {
             before(grammarAccess.getOpenClosedAccess().getLeftParenthesisKeyword_0()); 
            match(input,44,FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8260); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4117:1: rule__OpenClosed__Group__1 : rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 ;
    public final void rule__OpenClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4121:1: ( rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4122:2: rule__OpenClosed__Group__1__Impl rule__OpenClosed__Group__2
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18291);
            rule__OpenClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18294);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4129:1: rule__OpenClosed__Group__1__Impl : ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__OpenClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4133:1: ( ( ( rule__OpenClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4134:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4134:1: ( ( rule__OpenClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4135:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4136:1: ( rule__OpenClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4136:2: rule__OpenClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8321);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4146:1: rule__OpenClosed__Group__2 : rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 ;
    public final void rule__OpenClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4150:1: ( rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4151:2: rule__OpenClosed__Group__2__Impl rule__OpenClosed__Group__3
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28351);
            rule__OpenClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28354);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4158:1: rule__OpenClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__OpenClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4162:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4163:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4163:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4164:1: ','
            {
             before(grammarAccess.getOpenClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8382); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4177:1: rule__OpenClosed__Group__3 : rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 ;
    public final void rule__OpenClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4181:1: ( rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4182:2: rule__OpenClosed__Group__3__Impl rule__OpenClosed__Group__4
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38413);
            rule__OpenClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38416);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4189:1: rule__OpenClosed__Group__3__Impl : ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__OpenClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4193:1: ( ( ( rule__OpenClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4194:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4194:1: ( ( rule__OpenClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4195:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4196:1: ( rule__OpenClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4196:2: rule__OpenClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8443);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4206:1: rule__OpenClosed__Group__4 : rule__OpenClosed__Group__4__Impl ;
    public final void rule__OpenClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4210:1: ( rule__OpenClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4211:2: rule__OpenClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__48473);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4217:1: rule__OpenClosed__Group__4__Impl : ( ']' ) ;
    public final void rule__OpenClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4221:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4222:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4222:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4223:1: ']'
            {
             before(grammarAccess.getOpenClosedAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__OpenClosed__Group__4__Impl8501); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4246:1: rule__ClosedClosed__Group__0 : rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 ;
    public final void rule__ClosedClosed__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4250:1: ( rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4251:2: rule__ClosedClosed__Group__0__Impl rule__ClosedClosed__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__08542);
            rule__ClosedClosed__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__08545);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4258:1: rule__ClosedClosed__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedClosed__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4262:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4263:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4263:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4264:1: '['
            {
             before(grammarAccess.getClosedClosedAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl8573); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4277:1: rule__ClosedClosed__Group__1 : rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 ;
    public final void rule__ClosedClosed__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4281:1: ( rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4282:2: rule__ClosedClosed__Group__1__Impl rule__ClosedClosed__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__18604);
            rule__ClosedClosed__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__18607);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4289:1: rule__ClosedClosed__Group__1__Impl : ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedClosed__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4293:1: ( ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4294:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4294:1: ( ( rule__ClosedClosed__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4295:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4296:1: ( rule__ClosedClosed__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4296:2: rule__ClosedClosed__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl8634);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4306:1: rule__ClosedClosed__Group__2 : rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 ;
    public final void rule__ClosedClosed__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4310:1: ( rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4311:2: rule__ClosedClosed__Group__2__Impl rule__ClosedClosed__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__28664);
            rule__ClosedClosed__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__28667);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4318:1: rule__ClosedClosed__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedClosed__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4322:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4323:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4323:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4324:1: ','
            {
             before(grammarAccess.getClosedClosedAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl8695); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4337:1: rule__ClosedClosed__Group__3 : rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 ;
    public final void rule__ClosedClosed__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4341:1: ( rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4342:2: rule__ClosedClosed__Group__3__Impl rule__ClosedClosed__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__38726);
            rule__ClosedClosed__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__38729);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4349:1: rule__ClosedClosed__Group__3__Impl : ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedClosed__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4353:1: ( ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4354:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4354:1: ( ( rule__ClosedClosed__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4355:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4356:1: ( rule__ClosedClosed__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4356:2: rule__ClosedClosed__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl8756);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4366:1: rule__ClosedClosed__Group__4 : rule__ClosedClosed__Group__4__Impl ;
    public final void rule__ClosedClosed__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4370:1: ( rule__ClosedClosed__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4371:2: rule__ClosedClosed__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__48786);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4377:1: rule__ClosedClosed__Group__4__Impl : ( ')' ) ;
    public final void rule__ClosedClosed__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4381:1: ( ( ')' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4382:1: ( ')' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4382:1: ( ')' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4383:1: ')'
            {
             before(grammarAccess.getClosedClosedAccess().getRightParenthesisKeyword_4()); 
            match(input,45,FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl8814); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4406:1: rule__ClosedOpen__Group__0 : rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 ;
    public final void rule__ClosedOpen__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4410:1: ( rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4411:2: rule__ClosedOpen__Group__0__Impl rule__ClosedOpen__Group__1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__08855);
            rule__ClosedOpen__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__08858);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4418:1: rule__ClosedOpen__Group__0__Impl : ( '[' ) ;
    public final void rule__ClosedOpen__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4422:1: ( ( '[' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4423:1: ( '[' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4423:1: ( '[' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4424:1: '['
            {
             before(grammarAccess.getClosedOpenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,52,FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl8886); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4437:1: rule__ClosedOpen__Group__1 : rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 ;
    public final void rule__ClosedOpen__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4441:1: ( rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4442:2: rule__ClosedOpen__Group__1__Impl rule__ClosedOpen__Group__2
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__18917);
            rule__ClosedOpen__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__18920);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4449:1: rule__ClosedOpen__Group__1__Impl : ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) ;
    public final void rule__ClosedOpen__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4453:1: ( ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4454:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4454:1: ( ( rule__ClosedOpen__LowerBoundAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4455:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4456:1: ( rule__ClosedOpen__LowerBoundAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4456:2: rule__ClosedOpen__LowerBoundAssignment_1
            {
            pushFollow(FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl8947);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4466:1: rule__ClosedOpen__Group__2 : rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 ;
    public final void rule__ClosedOpen__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4470:1: ( rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4471:2: rule__ClosedOpen__Group__2__Impl rule__ClosedOpen__Group__3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__28977);
            rule__ClosedOpen__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__28980);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4478:1: rule__ClosedOpen__Group__2__Impl : ( ',' ) ;
    public final void rule__ClosedOpen__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4482:1: ( ( ',' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4483:1: ( ',' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4483:1: ( ',' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4484:1: ','
            {
             before(grammarAccess.getClosedOpenAccess().getCommaKeyword_2()); 
            match(input,50,FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9008); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4497:1: rule__ClosedOpen__Group__3 : rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 ;
    public final void rule__ClosedOpen__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4501:1: ( rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4502:2: rule__ClosedOpen__Group__3__Impl rule__ClosedOpen__Group__4
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39039);
            rule__ClosedOpen__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39042);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4509:1: rule__ClosedOpen__Group__3__Impl : ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) ;
    public final void rule__ClosedOpen__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4513:1: ( ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4514:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4514:1: ( ( rule__ClosedOpen__UpperBoundAssignment_3 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4515:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundAssignment_3()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4516:1: ( rule__ClosedOpen__UpperBoundAssignment_3 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4516:2: rule__ClosedOpen__UpperBoundAssignment_3
            {
            pushFollow(FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9069);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4526:1: rule__ClosedOpen__Group__4 : rule__ClosedOpen__Group__4__Impl ;
    public final void rule__ClosedOpen__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4530:1: ( rule__ClosedOpen__Group__4__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4531:2: rule__ClosedOpen__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49099);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4537:1: rule__ClosedOpen__Group__4__Impl : ( ']' ) ;
    public final void rule__ClosedOpen__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4541:1: ( ( ']' ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4542:1: ( ']' )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4542:1: ( ']' )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4543:1: ']'
            {
             before(grammarAccess.getClosedOpenAccess().getRightSquareBracketKeyword_4()); 
            match(input,51,FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9127); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4566:1: rule__NumericFilter__Group__0 : rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 ;
    public final void rule__NumericFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4570:1: ( rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4571:2: rule__NumericFilter__Group__0__Impl rule__NumericFilter__Group__1
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09168);
            rule__NumericFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09171);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4578:1: rule__NumericFilter__Group__0__Impl : ( ( rule__NumericFilter__OperatorAssignment_0 ) ) ;
    public final void rule__NumericFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4582:1: ( ( ( rule__NumericFilter__OperatorAssignment_0 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4583:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4583:1: ( ( rule__NumericFilter__OperatorAssignment_0 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4584:1: ( rule__NumericFilter__OperatorAssignment_0 )
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4585:1: ( rule__NumericFilter__OperatorAssignment_0 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4585:2: rule__NumericFilter__OperatorAssignment_0
            {
            pushFollow(FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9198);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4595:1: rule__NumericFilter__Group__1 : rule__NumericFilter__Group__1__Impl ;
    public final void rule__NumericFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4599:1: ( rule__NumericFilter__Group__1__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4600:2: rule__NumericFilter__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19228);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4606:1: rule__NumericFilter__Group__1__Impl : ( ( rule__NumericFilter__ValueAssignment_1 ) ) ;
    public final void rule__NumericFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4610:1: ( ( ( rule__NumericFilter__ValueAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4611:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4611:1: ( ( rule__NumericFilter__ValueAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4612:1: ( rule__NumericFilter__ValueAssignment_1 )
            {
             before(grammarAccess.getNumericFilterAccess().getValueAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4613:1: ( rule__NumericFilter__ValueAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4613:2: rule__NumericFilter__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9255);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4627:1: rule__LiteralFilter__Group__0 : rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 ;
    public final void rule__LiteralFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4631:1: ( rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4632:2: rule__LiteralFilter__Group__0__Impl rule__LiteralFilter__Group__1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09289);
            rule__LiteralFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09292);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4639:1: rule__LiteralFilter__Group__0__Impl : ( ( rule__LiteralFilter__NegAssignment_0 )? ) ;
    public final void rule__LiteralFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4643:1: ( ( ( rule__LiteralFilter__NegAssignment_0 )? ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4644:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4644:1: ( ( rule__LiteralFilter__NegAssignment_0 )? )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4645:1: ( rule__LiteralFilter__NegAssignment_0 )?
            {
             before(grammarAccess.getLiteralFilterAccess().getNegAssignment_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4646:1: ( rule__LiteralFilter__NegAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==11) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4646:2: rule__LiteralFilter__NegAssignment_0
                    {
                    pushFollow(FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9319);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4656:1: rule__LiteralFilter__Group__1 : rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 ;
    public final void rule__LiteralFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4660:1: ( rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4661:2: rule__LiteralFilter__Group__1__Impl rule__LiteralFilter__Group__2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19350);
            rule__LiteralFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19353);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4668:1: rule__LiteralFilter__Group__1__Impl : ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) ;
    public final void rule__LiteralFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4672:1: ( ( ( rule__LiteralFilter__OperatorAssignment_1 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4673:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4673:1: ( ( rule__LiteralFilter__OperatorAssignment_1 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4674:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorAssignment_1()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4675:1: ( rule__LiteralFilter__OperatorAssignment_1 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4675:2: rule__LiteralFilter__OperatorAssignment_1
            {
            pushFollow(FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9380);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4685:1: rule__LiteralFilter__Group__2 : rule__LiteralFilter__Group__2__Impl ;
    public final void rule__LiteralFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4689:1: ( rule__LiteralFilter__Group__2__Impl )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4690:2: rule__LiteralFilter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29410);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4696:1: rule__LiteralFilter__Group__2__Impl : ( ( rule__LiteralFilter__ValueAssignment_2 ) ) ;
    public final void rule__LiteralFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4700:1: ( ( ( rule__LiteralFilter__ValueAssignment_2 ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4701:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4701:1: ( ( rule__LiteralFilter__ValueAssignment_2 ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4702:1: ( rule__LiteralFilter__ValueAssignment_2 )
            {
             before(grammarAccess.getLiteralFilterAccess().getValueAssignment_2()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4703:1: ( rule__LiteralFilter__ValueAssignment_2 )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4703:2: rule__LiteralFilter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9437);
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


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4720:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4724:1: ( ( ruleQualifiedName ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4725:1: ( ruleQualifiedName )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4725:1: ( ruleQualifiedName )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4726:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_19478);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4735:1: rule__PackageDeclaration__UsagesAssignment_2 : ( ruleUsage ) ;
    public final void rule__PackageDeclaration__UsagesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4739:1: ( ( ruleUsage ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4740:1: ( ruleUsage )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4740:1: ( ruleUsage )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4741:1: ruleUsage
            {
             before(grammarAccess.getPackageDeclarationAccess().getUsagesUsageParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_29509);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4750:1: rule__PackageDeclaration__ModelAssignment_3 : ( ruleModel ) ;
    public final void rule__PackageDeclaration__ModelAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4754:1: ( ( ruleModel ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4755:1: ( ruleModel )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4755:1: ( ruleModel )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4756:1: ruleModel
            {
             before(grammarAccess.getPackageDeclarationAccess().getModelModelParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_39540);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4765:1: rule__IQUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__IQUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4769:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4770:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4770:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4771:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getIQUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_19571);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4780:1: rule__EventSourceUsage__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__EventSourceUsage__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4784:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4785:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4785:1: ( ruleQualifiedNameWithWildcard )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4786:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getEventSourceUsageAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_19602);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4795:1: rule__Model__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__Model__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4799:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4800:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4800:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4801:1: ruleAnnotations
            {
             before(grammarAccess.getModelAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_09633);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4810:1: rule__Model__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Model__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4814:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4815:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4815:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4816:1: RULE_ID
            {
             before(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Model__NameAssignment_29664); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4825:1: rule__Model__EventsAssignment_4 : ( ruleEvent ) ;
    public final void rule__Model__EventsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4829:1: ( ( ruleEvent ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4830:1: ( ruleEvent )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4830:1: ( ruleEvent )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4831:1: ruleEvent
            {
             before(grammarAccess.getModelAccess().getEventsEventParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_49695);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4840:1: rule__AtomicEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__AtomicEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4844:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4845:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4845:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4846:1: ruleAnnotations
            {
             before(grammarAccess.getAtomicEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_09726);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4855:1: rule__AtomicEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__AtomicEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4859:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4860:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4860:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4861:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_29757); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4870:1: rule__AtomicEvent__SourceAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__AtomicEvent__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4874:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4875:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4875:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4876:1: ( RULE_ID )
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceCrossReference_7_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4877:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4878:1: RULE_ID
            {
             before(grammarAccess.getAtomicEventAccess().getSourceSourceIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_79792); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4889:1: rule__AtomicEvent__IdAssignment_10 : ( RULE_STRING ) ;
    public final void rule__AtomicEvent__IdAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4893:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4894:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4894:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4895:1: RULE_STRING
            {
             before(grammarAccess.getAtomicEventAccess().getIdSTRINGTerminalRuleCall_10_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_109827); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4904:1: rule__AtomicEvent__ParameterFiltersAssignment_13 : ( ruleParameterFilter ) ;
    public final void rule__AtomicEvent__ParameterFiltersAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4908:1: ( ( ruleParameterFilter ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4909:1: ( ruleParameterFilter )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4909:1: ( ruleParameterFilter )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4910:1: ruleParameterFilter
            {
             before(grammarAccess.getAtomicEventAccess().getParameterFiltersParameterFilterParserRuleCall_13_0()); 
            pushFollow(FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_139858);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4919:1: rule__IQPatternEvent__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__IQPatternEvent__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4923:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4924:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4925:1: RULE_ID
            {
             before(grammarAccess.getIQPatternEventAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_19889); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4934:1: rule__IQPatternEvent__IqpatternAssignment_6 : ( ruleIQPattern ) ;
    public final void rule__IQPatternEvent__IqpatternAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4938:1: ( ( ruleIQPattern ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4939:1: ( ruleIQPattern )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4939:1: ( ruleIQPattern )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4940:1: ruleIQPattern
            {
             before(grammarAccess.getIQPatternEventAccess().getIqpatternIQPatternParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleIQPattern_in_rule__IQPatternEvent__IqpatternAssignment_69920);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4949:1: rule__IQPatternEvent__ChangeTypeAssignment_9 : ( ruleIQPatternChangeType ) ;
    public final void rule__IQPatternEvent__ChangeTypeAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4953:1: ( ( ruleIQPatternChangeType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4954:1: ( ruleIQPatternChangeType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4954:1: ( ruleIQPatternChangeType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4955:1: ruleIQPatternChangeType
            {
             before(grammarAccess.getIQPatternEventAccess().getChangeTypeIQPatternChangeTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_99951);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4964:1: rule__ComplexEvent__AnnotationsAssignment_0 : ( ruleAnnotations ) ;
    public final void rule__ComplexEvent__AnnotationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4968:1: ( ( ruleAnnotations ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4969:1: ( ruleAnnotations )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4969:1: ( ruleAnnotations )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4970:1: ruleAnnotations
            {
             before(grammarAccess.getComplexEventAccess().getAnnotationsAnnotationsParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_09982);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4979:1: rule__ComplexEvent__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__ComplexEvent__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4983:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4984:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4984:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4985:1: RULE_ID
            {
             before(grammarAccess.getComplexEventAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_210013); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4994:1: rule__ComplexEvent__ParamlistAssignment_3 : ( ruleCEParamlist ) ;
    public final void rule__ComplexEvent__ParamlistAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4998:1: ( ( ruleCEParamlist ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4999:1: ( ruleCEParamlist )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:4999:1: ( ruleCEParamlist )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5000:1: ruleCEParamlist
            {
             before(grammarAccess.getComplexEventAccess().getParamlistCEParamlistParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_310044);
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


    // $ANTLR start "rule__CEParamlist__ParamsAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5009:1: rule__CEParamlist__ParamsAssignment_2 : ( ruleParamWithType ) ;
    public final void rule__CEParamlist__ParamsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5013:1: ( ( ruleParamWithType ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5014:1: ( ruleParamWithType )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5014:1: ( ruleParamWithType )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5015:1: ruleParamWithType
            {
             before(grammarAccess.getCEParamlistAccess().getParamsParamWithTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParamWithType_in_rule__CEParamlist__ParamsAssignment_210075);
            ruleParamWithType();

            state._fsp--;

             after(grammarAccess.getCEParamlistAccess().getParamsParamWithTypeParserRuleCall_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParamWithType__NameAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5024:1: rule__ParamWithType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParamWithType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5028:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5029:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5029:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5030:1: RULE_ID
            {
             before(grammarAccess.getParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParamWithType__NameAssignment_010106); 
             after(grammarAccess.getParamWithTypeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamWithType__NameAssignment_0"


    // $ANTLR start "rule__ParamWithType__TypeAssignment_2"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5039:1: rule__ParamWithType__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ParamWithType__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5043:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5044:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5044:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5045:1: ( RULE_ID )
            {
             before(grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventCrossReference_2_0()); 
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5046:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5047:1: RULE_ID
            {
             before(grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParamWithType__TypeAssignment_210141); 
             after(grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getParamWithTypeAccess().getTypeAbstractAtomicEventCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamWithType__TypeAssignment_2"


    // $ANTLR start "rule__ParameterFilter__AttributeNameAssignment_0"
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5058:1: rule__ParameterFilter__AttributeNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterFilter__AttributeNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5062:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5063:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5063:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5064:1: RULE_ID
            {
             before(grammarAccess.getParameterFilterAccess().getAttributeNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_010176); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5073:1: rule__ParameterFilter__ParamFilterRuleAssignment_1 : ( ruleParameterFilterRule ) ;
    public final void rule__ParameterFilter__ParamFilterRuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5077:1: ( ( ruleParameterFilterRule ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5078:1: ( ruleParameterFilterRule )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5078:1: ( ruleParameterFilterRule )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5079:1: ruleParameterFilterRule
            {
             before(grammarAccess.getParameterFilterAccess().getParamFilterRuleParameterFilterRuleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_110207);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5088:1: rule__IQPattern__NameAssignment : ( RULE_ID ) ;
    public final void rule__IQPattern__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5092:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5093:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5093:1: ( RULE_ID )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5094:1: RULE_ID
            {
             before(grammarAccess.getIQPatternAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__IQPattern__NameAssignment10238); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5103:1: rule__ContextAnnotation__ContextAssignment_2 : ( ruleContext ) ;
    public final void rule__ContextAnnotation__ContextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5107:1: ( ( ruleContext ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5108:1: ( ruleContext )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5108:1: ( ruleContext )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5109:1: ruleContext
            {
             before(grammarAccess.getContextAnnotationAccess().getContextContextEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_210269);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5118:1: rule__SamplingAnnotation__SamplingAssignment_2 : ( RULE_INT ) ;
    public final void rule__SamplingAnnotation__SamplingAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5122:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5123:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5123:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5124:1: RULE_INT
            {
             before(grammarAccess.getSamplingAnnotationAccess().getSamplingINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_210300); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5133:1: rule__PriorityAnnotation__PriorityAssignment_2 : ( RULE_INT ) ;
    public final void rule__PriorityAnnotation__PriorityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5137:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5138:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5138:1: ( RULE_INT )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5139:1: RULE_INT
            {
             before(grammarAccess.getPriorityAnnotationAccess().getPriorityINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_210331); 
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5148:1: rule__RangeFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__RangeFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5152:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5153:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5153:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5154:1: ruleNegationOpartor
            {
             before(grammarAccess.getRangeFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_010362);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5163:1: rule__RangeFilter__RangeAssignment_2 : ( ruleRange ) ;
    public final void rule__RangeFilter__RangeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5167:1: ( ( ruleRange ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5168:1: ( ruleRange )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5168:1: ( ruleRange )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5169:1: ruleRange
            {
             before(grammarAccess.getRangeFilterAccess().getRangeRangeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_210393);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5178:1: rule__OpenOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5182:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5183:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5183:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5184:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_110424);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5193:1: rule__OpenOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5197:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5198:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5198:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5199:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_310455);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5208:1: rule__OpenClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5212:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5213:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5213:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5214:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_110486);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5223:1: rule__OpenClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__OpenClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5227:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5228:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5228:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5229:1: ruleDOUBLE
            {
             before(grammarAccess.getOpenClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_310517);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5238:1: rule__ClosedClosed__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5242:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5243:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5243:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5244:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_110548);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5253:1: rule__ClosedClosed__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedClosed__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5257:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5258:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5258:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5259:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedClosedAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_310579);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5268:1: rule__ClosedOpen__LowerBoundAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__LowerBoundAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5272:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5273:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5273:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5274:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getLowerBoundDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_110610);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5283:1: rule__ClosedOpen__UpperBoundAssignment_3 : ( ruleDOUBLE ) ;
    public final void rule__ClosedOpen__UpperBoundAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5287:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5288:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5288:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5289:1: ruleDOUBLE
            {
             before(grammarAccess.getClosedOpenAccess().getUpperBoundDOUBLEParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_310641);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5298:1: rule__NumericFilter__OperatorAssignment_0 : ( ruleNumericOperator ) ;
    public final void rule__NumericFilter__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5302:1: ( ( ruleNumericOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5303:1: ( ruleNumericOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5303:1: ( ruleNumericOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5304:1: ruleNumericOperator
            {
             before(grammarAccess.getNumericFilterAccess().getOperatorNumericOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_010672);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5313:1: rule__NumericFilter__ValueAssignment_1 : ( ruleDOUBLE ) ;
    public final void rule__NumericFilter__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5317:1: ( ( ruleDOUBLE ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5318:1: ( ruleDOUBLE )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5318:1: ( ruleDOUBLE )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5319:1: ruleDOUBLE
            {
             before(grammarAccess.getNumericFilterAccess().getValueDOUBLEParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_110703);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5328:1: rule__LiteralFilter__NegAssignment_0 : ( ruleNegationOpartor ) ;
    public final void rule__LiteralFilter__NegAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5332:1: ( ( ruleNegationOpartor ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5333:1: ( ruleNegationOpartor )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5333:1: ( ruleNegationOpartor )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5334:1: ruleNegationOpartor
            {
             before(grammarAccess.getLiteralFilterAccess().getNegNegationOpartorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_010734);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5343:1: rule__LiteralFilter__OperatorAssignment_1 : ( ruleLiteralOperator ) ;
    public final void rule__LiteralFilter__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5347:1: ( ( ruleLiteralOperator ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5348:1: ( ruleLiteralOperator )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5348:1: ( ruleLiteralOperator )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5349:1: ruleLiteralOperator
            {
             before(grammarAccess.getLiteralFilterAccess().getOperatorLiteralOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_110765);
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
    // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5358:1: rule__LiteralFilter__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__LiteralFilter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5362:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5363:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5363:1: ( RULE_STRING )
            // ../hu.bme.mit.incquery.edl.ui/src-gen/hu/bme/mit/incquery/vedl/ui/contentassist/antlr/internal/InternalEdl.g:5364:1: RULE_STRING
            {
             before(grammarAccess.getLiteralFilterAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_210796); 
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
            return "1054:1: rule__Event__Alternatives : ( ( ruleAbstractAtomicEvent ) | ( ruleComplexEvent ) );";
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
            return "1154:1: rule__Range__Alternatives : ( ( ruleOpenOpen ) | ( ruleOpenClosed ) | ( ruleClosedClosed ) | ( ruleClosedOpen ) );";
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
    public static final BitSet FOLLOW_ruleParamWithType_in_entryRuleParamWithType910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamWithType917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__0_in_ruleParamWithType943 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_rule__IQPatternChangeType__Alternatives_in_ruleIQPatternChangeType2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Context__Alternatives_in_ruleContext2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQUsage_in_rule__Usage__Alternatives2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEventSourceUsage_in_rule__Usage__Alternatives2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractAtomicEvent_in_rule__Event__Alternatives2182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexEvent_in_rule__Event__Alternatives2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtomicEvent_in_rule__AbstractAtomicEvent__Alternatives2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternEvent_in_rule__AbstractAtomicEvent__Alternatives2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextAnnotation_in_rule__Annotations__Alternatives2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSamplingAnnotation_in_rule__Annotations__Alternatives2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePriorityAnnotation_in_rule__Annotations__Alternatives2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFilter_in_rule__ParameterFilterRule__Alternatives2346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericFilter_in_rule__ParameterFilterRule__Alternatives2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFilter_in_rule__ParameterFilterRule__Alternatives2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenOpen_in_rule__Range__Alternatives2412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOpenClosed_in_rule__Range__Alternatives2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedClosed_in_rule__Range__Alternatives2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClosedOpen_in_rule__Range__Alternatives2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__NumericOperator__Alternatives2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__NumericOperator__Alternatives2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__NumericOperator__Alternatives2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NumericOperator__Alternatives2556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NumericOperator__Alternatives2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NumericOperator__Alternatives2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__LiteralOperator__Alternatives2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__LiteralOperator__Alternatives2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__LiteralOperator__Alternatives2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__IQPatternChangeType__Alternatives2706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__IQPatternChangeType__Alternatives2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Context__Alternatives2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Context__Alternatives2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Context__Alternatives2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__0__Impl_in_rule__PackageDeclaration__Group__02838 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1_in_rule__PackageDeclaration__Group__02841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__PackageDeclaration__Group__0__Impl2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__1__Impl_in_rule__PackageDeclaration__Group__12900 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2_in_rule__PackageDeclaration__Group__12903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__NameAssignment_1_in_rule__PackageDeclaration__Group__1__Impl2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__2__Impl_in_rule__PackageDeclaration__Group__22960 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3_in_rule__PackageDeclaration__Group__22963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__UsagesAssignment_2_in_rule__PackageDeclaration__Group__2__Impl2990 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__Group__3__Impl_in_rule__PackageDeclaration__Group__33021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDeclaration__ModelAssignment_3_in_rule__PackageDeclaration__Group__3__Impl3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__0__Impl_in_rule__DOUBLE__Group__03086 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1_in_rule__DOUBLE__Group__03089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group__0__Impl3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group__1__Impl_in_rule__DOUBLE__Group__13145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0_in_rule__DOUBLE__Group__1__Impl3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__0__Impl_in_rule__DOUBLE__Group_1__03207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1_in_rule__DOUBLE__Group_1__03210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__DOUBLE__Group_1__0__Impl3238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DOUBLE__Group_1__1__Impl_in_rule__DOUBLE__Group_1__13269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__DOUBLE__Group_1__1__Impl3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03329 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3415 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__QualifiedName__Group_1__0__Impl3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__03572 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__03575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__13631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__QualifiedNameWithWildcard__Group__1__Impl3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__0__Impl_in_rule__IQUsage__Group__03697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1_in_rule__IQUsage__Group__03700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__IQUsage__Group__0__Impl3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__Group__1__Impl_in_rule__IQUsage__Group__13759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQUsage__ImportedNamespaceAssignment_1_in_rule__IQUsage__Group__1__Impl3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__0__Impl_in_rule__EventSourceUsage__Group__03820 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1_in_rule__EventSourceUsage__Group__03823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__EventSourceUsage__Group__0__Impl3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__Group__1__Impl_in_rule__EventSourceUsage__Group__13882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EventSourceUsage__ImportedNamespaceAssignment_1_in_rule__EventSourceUsage__Group__1__Impl3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0__Impl_in_rule__Model__Group__03943 = new BitSet(new long[]{0x0001C000E0000000L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__03946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__AnnotationsAssignment_0_in_rule__Model__Group__0__Impl3973 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1__Impl_in_rule__Model__Group__14004 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__14007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Model__Group__1__Impl4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__2__Impl_in_rule__Model__Group__24066 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Model__Group__3_in_rule__Model__Group__24069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__NameAssignment_2_in_rule__Model__Group__2__Impl4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__3__Impl_in_rule__Model__Group__34126 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__4_in_rule__Model__Group__34129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Model__Group__3__Impl4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__4__Impl_in_rule__Model__Group__44188 = new BitSet(new long[]{0x0001C90600000000L});
    public static final BitSet FOLLOW_rule__Model__Group__5_in_rule__Model__Group__44191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__EventsAssignment_4_in_rule__Model__Group__4__Impl4218 = new BitSet(new long[]{0x0001C90400000002L});
    public static final BitSet FOLLOW_rule__Model__Group__5__Impl_in_rule__Model__Group__54249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Model__Group__5__Impl4277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__0__Impl_in_rule__AtomicEvent__Group__04320 = new BitSet(new long[]{0x0001C00400000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1_in_rule__AtomicEvent__Group__04323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__AnnotationsAssignment_0_in_rule__AtomicEvent__Group__0__Impl4350 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__1__Impl_in_rule__AtomicEvent__Group__14381 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2_in_rule__AtomicEvent__Group__14384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__AtomicEvent__Group__1__Impl4412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__2__Impl_in_rule__AtomicEvent__Group__24443 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3_in_rule__AtomicEvent__Group__24446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__NameAssignment_2_in_rule__AtomicEvent__Group__2__Impl4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__3__Impl_in_rule__AtomicEvent__Group__34503 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4_in_rule__AtomicEvent__Group__34506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AtomicEvent__Group__3__Impl4534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__4__Impl_in_rule__AtomicEvent__Group__44565 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5_in_rule__AtomicEvent__Group__44568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__4__Impl4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__5__Impl_in_rule__AtomicEvent__Group__54627 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6_in_rule__AtomicEvent__Group__54630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__AtomicEvent__Group__5__Impl4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__6__Impl_in_rule__AtomicEvent__Group__64689 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7_in_rule__AtomicEvent__Group__64692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__6__Impl4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__7__Impl_in_rule__AtomicEvent__Group__74751 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8_in_rule__AtomicEvent__Group__74754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__SourceAssignment_7_in_rule__AtomicEvent__Group__7__Impl4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__8__Impl_in_rule__AtomicEvent__Group__84811 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9_in_rule__AtomicEvent__Group__84814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__AtomicEvent__Group__8__Impl4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__9__Impl_in_rule__AtomicEvent__Group__94873 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10_in_rule__AtomicEvent__Group__94876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__AtomicEvent__Group__9__Impl4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__10__Impl_in_rule__AtomicEvent__Group__104935 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11_in_rule__AtomicEvent__Group__104938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__IdAssignment_10_in_rule__AtomicEvent__Group__10__Impl4965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__11__Impl_in_rule__AtomicEvent__Group__114995 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12_in_rule__AtomicEvent__Group__114998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__AtomicEvent__Group__11__Impl5026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__12__Impl_in_rule__AtomicEvent__Group__125057 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13_in_rule__AtomicEvent__Group__125060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__AtomicEvent__Group__12__Impl5088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__13__Impl_in_rule__AtomicEvent__Group__135119 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14_in_rule__AtomicEvent__Group__135122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5151 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__ParameterFiltersAssignment_13_in_rule__AtomicEvent__Group__13__Impl5163 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__14__Impl_in_rule__AtomicEvent__Group__145196 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15_in_rule__AtomicEvent__Group__145199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__14__Impl5227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AtomicEvent__Group__15__Impl_in_rule__AtomicEvent__Group__155258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__AtomicEvent__Group__15__Impl5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__0__Impl_in_rule__IQPatternEvent__Group__05349 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1_in_rule__IQPatternEvent__Group__05352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__IQPatternEvent__Group__0__Impl5380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__1__Impl_in_rule__IQPatternEvent__Group__15411 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2_in_rule__IQPatternEvent__Group__15414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__NameAssignment_1_in_rule__IQPatternEvent__Group__1__Impl5441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__2__Impl_in_rule__IQPatternEvent__Group__25471 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3_in_rule__IQPatternEvent__Group__25474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__IQPatternEvent__Group__2__Impl5502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__3__Impl_in_rule__IQPatternEvent__Group__35533 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4_in_rule__IQPatternEvent__Group__35536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IQPatternEvent__Group__3__Impl5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__4__Impl_in_rule__IQPatternEvent__Group__45595 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5_in_rule__IQPatternEvent__Group__45598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__IQPatternEvent__Group__4__Impl5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__5__Impl_in_rule__IQPatternEvent__Group__55657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6_in_rule__IQPatternEvent__Group__55660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__5__Impl5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__6__Impl_in_rule__IQPatternEvent__Group__65719 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7_in_rule__IQPatternEvent__Group__65722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__IqpatternAssignment_6_in_rule__IQPatternEvent__Group__6__Impl5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__7__Impl_in_rule__IQPatternEvent__Group__75779 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8_in_rule__IQPatternEvent__Group__75782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__IQPatternEvent__Group__7__Impl5810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__8__Impl_in_rule__IQPatternEvent__Group__85841 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9_in_rule__IQPatternEvent__Group__85844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__IQPatternEvent__Group__8__Impl5872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__9__Impl_in_rule__IQPatternEvent__Group__95903 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10_in_rule__IQPatternEvent__Group__95906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__ChangeTypeAssignment_9_in_rule__IQPatternEvent__Group__9__Impl5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IQPatternEvent__Group__10__Impl_in_rule__IQPatternEvent__Group__105963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__IQPatternEvent__Group__10__Impl5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__0__Impl_in_rule__ComplexEvent__Group__06044 = new BitSet(new long[]{0x0001C90400000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1_in_rule__ComplexEvent__Group__06047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__AnnotationsAssignment_0_in_rule__ComplexEvent__Group__0__Impl6074 = new BitSet(new long[]{0x0001C00000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__1__Impl_in_rule__ComplexEvent__Group__16105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2_in_rule__ComplexEvent__Group__16108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ComplexEvent__Group__1__Impl6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__2__Impl_in_rule__ComplexEvent__Group__26167 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3_in_rule__ComplexEvent__Group__26170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__NameAssignment_2_in_rule__ComplexEvent__Group__2__Impl6197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__3__Impl_in_rule__ComplexEvent__Group__36227 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4_in_rule__ComplexEvent__Group__36230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__ParamlistAssignment_3_in_rule__ComplexEvent__Group__3__Impl6257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__4__Impl_in_rule__ComplexEvent__Group__46287 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5_in_rule__ComplexEvent__Group__46290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ComplexEvent__Group__4__Impl6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComplexEvent__Group__5__Impl_in_rule__ComplexEvent__Group__56349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ComplexEvent__Group__5__Impl6377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__0__Impl_in_rule__CEParamlist__Group__06420 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1_in_rule__CEParamlist__Group__06423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__1__Impl_in_rule__CEParamlist__Group__16481 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2_in_rule__CEParamlist__Group__16484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__CEParamlist__Group__1__Impl6512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__2__Impl_in_rule__CEParamlist__Group__26543 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3_in_rule__CEParamlist__Group__26546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CEParamlist__ParamsAssignment_2_in_rule__CEParamlist__Group__2__Impl6573 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_rule__CEParamlist__Group__3__Impl_in_rule__CEParamlist__Group__36604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__CEParamlist__Group__3__Impl6632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__0__Impl_in_rule__ParamWithType__Group__06671 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__1_in_rule__ParamWithType__Group__06674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__NameAssignment_0_in_rule__ParamWithType__Group__0__Impl6701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__1__Impl_in_rule__ParamWithType__Group__16731 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__2_in_rule__ParamWithType__Group__16734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ParamWithType__Group__1__Impl6762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__Group__2__Impl_in_rule__ParamWithType__Group__26793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamWithType__TypeAssignment_2_in_rule__ParamWithType__Group__2__Impl6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__0__Impl_in_rule__ParameterFilter__Group__06856 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1_in_rule__ParameterFilter__Group__06859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__AttributeNameAssignment_0_in_rule__ParameterFilter__Group__0__Impl6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__Group__1__Impl_in_rule__ParameterFilter__Group__16916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterFilter__ParamFilterRuleAssignment_1_in_rule__ParameterFilter__Group__1__Impl6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__0__Impl_in_rule__ContextAnnotation__Group__06977 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1_in_rule__ContextAnnotation__Group__06980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ContextAnnotation__Group__0__Impl7008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__1__Impl_in_rule__ContextAnnotation__Group__17039 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2_in_rule__ContextAnnotation__Group__17042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__ContextAnnotation__Group__1__Impl7070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__2__Impl_in_rule__ContextAnnotation__Group__27101 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3_in_rule__ContextAnnotation__Group__27104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__ContextAssignment_2_in_rule__ContextAnnotation__Group__2__Impl7131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextAnnotation__Group__3__Impl_in_rule__ContextAnnotation__Group__37161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ContextAnnotation__Group__3__Impl7189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__0__Impl_in_rule__SamplingAnnotation__Group__07228 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1_in_rule__SamplingAnnotation__Group__07231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__SamplingAnnotation__Group__0__Impl7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__1__Impl_in_rule__SamplingAnnotation__Group__17290 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2_in_rule__SamplingAnnotation__Group__17293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__SamplingAnnotation__Group__1__Impl7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__2__Impl_in_rule__SamplingAnnotation__Group__27352 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3_in_rule__SamplingAnnotation__Group__27355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__SamplingAssignment_2_in_rule__SamplingAnnotation__Group__2__Impl7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SamplingAnnotation__Group__3__Impl_in_rule__SamplingAnnotation__Group__37412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__SamplingAnnotation__Group__3__Impl7440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__0__Impl_in_rule__PriorityAnnotation__Group__07479 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1_in_rule__PriorityAnnotation__Group__07482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__PriorityAnnotation__Group__0__Impl7510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__1__Impl_in_rule__PriorityAnnotation__Group__17541 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2_in_rule__PriorityAnnotation__Group__17544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__PriorityAnnotation__Group__1__Impl7572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__2__Impl_in_rule__PriorityAnnotation__Group__27603 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3_in_rule__PriorityAnnotation__Group__27606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__PriorityAssignment_2_in_rule__PriorityAnnotation__Group__2__Impl7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PriorityAnnotation__Group__3__Impl_in_rule__PriorityAnnotation__Group__37663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__PriorityAnnotation__Group__3__Impl7691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__0__Impl_in_rule__RangeFilter__Group__07730 = new BitSet(new long[]{0x0002000000000800L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1_in_rule__RangeFilter__Group__07733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__NegAssignment_0_in_rule__RangeFilter__Group__0__Impl7760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__1__Impl_in_rule__RangeFilter__Group__17791 = new BitSet(new long[]{0x0010100000000000L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2_in_rule__RangeFilter__Group__17794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__RangeFilter__Group__1__Impl7822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__Group__2__Impl_in_rule__RangeFilter__Group__27853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeFilter__RangeAssignment_2_in_rule__RangeFilter__Group__2__Impl7880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__0__Impl_in_rule__OpenOpen__Group__07916 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1_in_rule__OpenOpen__Group__07919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenOpen__Group__0__Impl7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__1__Impl_in_rule__OpenOpen__Group__17978 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2_in_rule__OpenOpen__Group__17981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__LowerBoundAssignment_1_in_rule__OpenOpen__Group__1__Impl8008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__2__Impl_in_rule__OpenOpen__Group__28038 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3_in_rule__OpenOpen__Group__28041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenOpen__Group__2__Impl8069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__3__Impl_in_rule__OpenOpen__Group__38100 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4_in_rule__OpenOpen__Group__38103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__UpperBoundAssignment_3_in_rule__OpenOpen__Group__3__Impl8130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenOpen__Group__4__Impl_in_rule__OpenOpen__Group__48160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__OpenOpen__Group__4__Impl8188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__0__Impl_in_rule__OpenClosed__Group__08229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1_in_rule__OpenClosed__Group__08232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__OpenClosed__Group__0__Impl8260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__1__Impl_in_rule__OpenClosed__Group__18291 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2_in_rule__OpenClosed__Group__18294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__LowerBoundAssignment_1_in_rule__OpenClosed__Group__1__Impl8321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__2__Impl_in_rule__OpenClosed__Group__28351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3_in_rule__OpenClosed__Group__28354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__OpenClosed__Group__2__Impl8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__3__Impl_in_rule__OpenClosed__Group__38413 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4_in_rule__OpenClosed__Group__38416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__UpperBoundAssignment_3_in_rule__OpenClosed__Group__3__Impl8443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OpenClosed__Group__4__Impl_in_rule__OpenClosed__Group__48473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__OpenClosed__Group__4__Impl8501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__0__Impl_in_rule__ClosedClosed__Group__08542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1_in_rule__ClosedClosed__Group__08545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedClosed__Group__0__Impl8573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__1__Impl_in_rule__ClosedClosed__Group__18604 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2_in_rule__ClosedClosed__Group__18607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__LowerBoundAssignment_1_in_rule__ClosedClosed__Group__1__Impl8634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__2__Impl_in_rule__ClosedClosed__Group__28664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3_in_rule__ClosedClosed__Group__28667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedClosed__Group__2__Impl8695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__3__Impl_in_rule__ClosedClosed__Group__38726 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4_in_rule__ClosedClosed__Group__38729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__UpperBoundAssignment_3_in_rule__ClosedClosed__Group__3__Impl8756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedClosed__Group__4__Impl_in_rule__ClosedClosed__Group__48786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__ClosedClosed__Group__4__Impl8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__0__Impl_in_rule__ClosedOpen__Group__08855 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1_in_rule__ClosedOpen__Group__08858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ClosedOpen__Group__0__Impl8886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__1__Impl_in_rule__ClosedOpen__Group__18917 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2_in_rule__ClosedOpen__Group__18920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__LowerBoundAssignment_1_in_rule__ClosedOpen__Group__1__Impl8947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__2__Impl_in_rule__ClosedOpen__Group__28977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3_in_rule__ClosedOpen__Group__28980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ClosedOpen__Group__2__Impl9008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__3__Impl_in_rule__ClosedOpen__Group__39039 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4_in_rule__ClosedOpen__Group__39042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__UpperBoundAssignment_3_in_rule__ClosedOpen__Group__3__Impl9069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ClosedOpen__Group__4__Impl_in_rule__ClosedOpen__Group__49099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__ClosedOpen__Group__4__Impl9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__0__Impl_in_rule__NumericFilter__Group__09168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1_in_rule__NumericFilter__Group__09171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__OperatorAssignment_0_in_rule__NumericFilter__Group__0__Impl9198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__Group__1__Impl_in_rule__NumericFilter__Group__19228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NumericFilter__ValueAssignment_1_in_rule__NumericFilter__Group__1__Impl9255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__0__Impl_in_rule__LiteralFilter__Group__09289 = new BitSet(new long[]{0x00020000001FF800L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1_in_rule__LiteralFilter__Group__09292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__NegAssignment_0_in_rule__LiteralFilter__Group__0__Impl9319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__1__Impl_in_rule__LiteralFilter__Group__19350 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2_in_rule__LiteralFilter__Group__19353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__OperatorAssignment_1_in_rule__LiteralFilter__Group__1__Impl9380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__Group__2__Impl_in_rule__LiteralFilter__Group__29410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LiteralFilter__ValueAssignment_2_in_rule__LiteralFilter__Group__2__Impl9437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDeclaration__NameAssignment_19478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUsage_in_rule__PackageDeclaration__UsagesAssignment_29509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_rule__PackageDeclaration__ModelAssignment_39540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__IQUsage__ImportedNamespaceAssignment_19571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__EventSourceUsage__ImportedNamespaceAssignment_19602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__Model__AnnotationsAssignment_09633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Model__NameAssignment_29664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_rule__Model__EventsAssignment_49695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__AtomicEvent__AnnotationsAssignment_09726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__NameAssignment_29757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AtomicEvent__SourceAssignment_79792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__AtomicEvent__IdAssignment_109827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilter_in_rule__AtomicEvent__ParameterFiltersAssignment_139858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IQPatternEvent__NameAssignment_19889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPattern_in_rule__IQPatternEvent__IqpatternAssignment_69920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIQPatternChangeType_in_rule__IQPatternEvent__ChangeTypeAssignment_99951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotations_in_rule__ComplexEvent__AnnotationsAssignment_09982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ComplexEvent__NameAssignment_210013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCEParamlist_in_rule__ComplexEvent__ParamlistAssignment_310044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamWithType_in_rule__CEParamlist__ParamsAssignment_210075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParamWithType__NameAssignment_010106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParamWithType__TypeAssignment_210141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParameterFilter__AttributeNameAssignment_010176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterFilterRule_in_rule__ParameterFilter__ParamFilterRuleAssignment_110207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__IQPattern__NameAssignment10238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContext_in_rule__ContextAnnotation__ContextAssignment_210269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__SamplingAnnotation__SamplingAssignment_210300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__PriorityAnnotation__PriorityAssignment_210331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__RangeFilter__NegAssignment_010362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rule__RangeFilter__RangeAssignment_210393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__LowerBoundAssignment_110424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenOpen__UpperBoundAssignment_310455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__LowerBoundAssignment_110486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__OpenClosed__UpperBoundAssignment_310517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__LowerBoundAssignment_110548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedClosed__UpperBoundAssignment_310579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__LowerBoundAssignment_110610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__ClosedOpen__UpperBoundAssignment_310641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericOperator_in_rule__NumericFilter__OperatorAssignment_010672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOUBLE_in_rule__NumericFilter__ValueAssignment_110703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegationOpartor_in_rule__LiteralFilter__NegAssignment_010734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralOperator_in_rule__LiteralFilter__OperatorAssignment_110765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__LiteralFilter__ValueAssignment_210796 = new BitSet(new long[]{0x0000000000000002L});

}