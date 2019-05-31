/**
 * Defines {@link org.estatio.module.communications.dom.impl.commchannel.CommunicationChannel} as an abstraction of a means for
 * two parties to interact with each other, along with a number of concrete implementations: 
 * {@link org.estatio.module.communications.dom.impl.commchannel.PhoneOrFaxNumber},
 * {@link org.estatio.module.communications.dom.impl.commchannel.EmailAddress} and
 * {@link org.estatio.module.communications.dom.impl.commchannel.PostalAddress}.
 * 
 * <p>
 * Every channel has a {@link org.estatio.module.communications.dom.impl.commchannel.CommunicationChannel#getType() associated}
 * {@link org.estatio.module.communications.dom.impl.commchannel.CommunicationChannelType type}, this acting as a power-type.
 *  
 * <p>
 * Every channel also has an {@link org.estatio.module.communications.dom.impl.commchannel.CommunicationChannel#getOwner() associated}
 * {@link org.estatio.module.communications.dom.impl.commchannel.CommunicationChannelOwner owner}; this is a polymorphic association
 * with the implementations being <tt>FixedAsset</tt> and <tt>Party</tt>.
 * 
 */
package org.estatio.module.communications.dom.impl.commchannel;